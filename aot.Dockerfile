# syntax=docker/dockerfile:1
FROM ghcr.io/graalvm/jdk-community:20.0.1 as dependencies

COPY .mvn ./.mvn
COPY mvnw pom.xml ./

COPY core/pom.xml ./core/
COPY webapp/pom.xml ./webapp/

# Installs all dependencies
RUN ./mvnw dependency:go-offline --fail-never

#####

FROM dependencies as modules

COPY webapp ./webapp
COPY core ./core

COPY ./wait-for-it.sh ./entrypoint.sh /
RUN chmod +x /wait-for-it.sh && \
    chmod +x /entrypoint.sh


# Package modules into final app, the standard way
FROM modules as setup
RUN ./mvnw clean compile spring-boot:process-aot package -pl webapp,core


# Final image
FROM ghcr.io/graalvm/graalvm-community:20.0.1 as production

COPY ./wait-for-it.sh ./entrypoint.sh /

RUN chmod +x /wait-for-it.sh /entrypoint.sh

COPY --from=setup /app/webapp/target/webapp-*.jar /app/webapp.jar

EXPOSE 25400
ENTRYPOINT ["/entrypoint.sh"]