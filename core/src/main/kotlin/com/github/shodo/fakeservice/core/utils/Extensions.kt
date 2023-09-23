package com.github.shodo.fakeservice.core.utils

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.springframework.http.HttpHeaders
import java.math.BigInteger
import java.net.URL
import java.util.*
import kotlin.math.pow
import kotlin.math.roundToLong

fun <T, R> List<T>.mapToMutable(mapping: (it: T) -> R): MutableList<R> {
    val l = this
    return mutableListOf<R>().apply { addAll(l.map { mapping(it) }) }
}

fun <T, R> List<T>.mapToMutableSet(mapping: (it: T) -> R): MutableSet<R> {
    val l = this
    return mutableSetOf<R>().apply { addAll(l.map { mapping(it) }) }
}

object UUIDSerializer : KSerializer<UUID> {
    override val descriptor = PrimitiveSerialDescriptor("UUID", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): UUID {
        return UUID.fromString(decoder.decodeString())
    }

    override fun serialize(encoder: Encoder, value: UUID) {
        encoder.encodeString(value.toString())
    }
}

operator fun Double?.plus(other: Double?): Double? {
    return if (this == null && other == null) {
        null
    } else {
        (this ?: 0.0) + (other ?: 0.0)
    }
}

operator fun Double?.div(other: Double): Double? {
    return if (this == null) {
        null
    } else {
        this / other
    }
}

fun Double.roundToPrecision(precision: Int): Double {
    val factor = 10.0.pow(precision.toDouble())
    return (this * factor).roundToLong() / factor
}

val camelRegex = "(?<=[a-zA-Z])[A-Z]".toRegex()
val snakeRegex = "_[a-zA-Z]".toRegex()

fun String.camelToSnakeCase(): String {
    return camelRegex.replace(this) {
        "_${it.value}"
    }.lowercase()
}

fun String.snakeToLowerCamelCase(): String {
    return snakeRegex.replace(this) {
        it.value.replace("_", "")
            .uppercase()
    }
}

fun String.snakeToUpperCamelCase(): String {
    return this.snakeToLowerCamelCase()
        .replaceFirstChar { char -> if (char.isLowerCase()) char.titlecase(Locale.getDefault()) else char.toString() }
}

fun String?.isNotNullOrBlank(): Boolean {
    return this != null && this.isNotBlank()
}


fun <T> Collection<T>?.isNotNullOrEmpty(): Boolean {
    return this != null && !this.isEmpty()
}

fun BigInteger.toMilliseconds(): BigInteger {
    return this.times(BigInteger.valueOf(1000))
}