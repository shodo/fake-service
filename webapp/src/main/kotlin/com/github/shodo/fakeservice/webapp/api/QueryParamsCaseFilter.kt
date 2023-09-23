package com.github.shodo.fakeservice.webapp.api

import com.github.shodo.fakeservice.core.utils.snakeToLowerCamelCase
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletRequestWrapper
import kotlin.collections.set


@Component
@Order(2)
class QueryParamsCaseFilter : Filter {

    override fun doFilter(request: ServletRequest?, response: ServletResponse?, chain: FilterChain?) {
        val parameters: MutableMap<String, Array<String>> = ConcurrentHashMap()

        for (param in request!!.parameterMap.keys) {
            val camelCaseParam: String = param.snakeToLowerCamelCase()
            parameters[camelCaseParam] = request.getParameterValues(param)
        }

        chain?.doFilter(object : HttpServletRequestWrapper(request as HttpServletRequest?) {
            override fun getParameter(name: String): String? {
                return if (parameters.containsKey(name)) parameters[name]!![0] else null
            }

            override fun getParameterNames(): Enumeration<String> {
                return object : Enumeration<String> {
                    var count = 0

                    override fun hasMoreElements(): Boolean {
                        return this.count < parameters.keys.size
                    }

                    override fun nextElement(): String {
                        if (this.count < parameters.keys.size) {
                            return parameters.keys.elementAt(this.count++)
                        }
                        throw NoSuchElementException("List enumeration asked for more elements than present")
                    }
                }
            }

            override fun getParameterValues(name: String): Array<String>? {
                return if (parameters.containsKey(name)) parameters[name]!! else null
            }

            override fun getParameterMap(): Map<String, Array<String>> {
                return parameters
            }
        }, response)
    }
}