# syntax=docker/dockerfile:1
FROM eclipse-temurin:17-jdk-jammy as dependencies

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
ENTRYPOINT ["/entrypoint.sh"]

# Package modules into final app, the standard way
FROM modules as setup
RUN ./mvnw -q package -DskipTests -T 3

# Final image
FROM eclipse-temurin:17-jre-jammy as production

COPY ./wait-for-it.sh ./entrypoint.sh /

RUN apt-get update && apt-get install curl -y && rm -rf /var/lib/apt/lists/* && \
    chmod +x /wait-for-it.sh /entrypoint.sh

COPY --from=setup /webapp/target/webapp-*.jar /webapp.jar

EXPOSE 25400
ENTRYPOINT ["/entrypoint.sh"]