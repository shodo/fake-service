#!/bin/bash
set -e

export PATH=$PATH:'/minerva/'

if [ "$RUNTIME_TYPE" == "webapp" ]; then
    echo "Start web application..."
    exec java -XX:+UseSerialGC -XX:+UseContainerSupport -XX:MaxRAMPercentage=80 -jar webapp.jar
elif [ "$RUNTIME_TYPE" == "setup" ]; then
    echo "Start setup..."
    exec ./mvnw -Dflyway.user=$DB_DEFAULT_USERNAME -Dflyway.password=$DB_DEFAULT_PASSWORD -Dflyway.schemas=public -Dflyway.url=jdbc:postgresql://$DB_DEFAULT_HOST:$DB_DEFAULT_PORT/$DB_DEFAULT_NAME -Dflyway.locations=classpath:db/migration flyway:migrate -pl core
elif [ "$RUNTIME_TYPE" == "test" ]; then
    echo "Starting tests..."
    export MAVEN_OPTS="-XX:MaxRAMPercentage=50"
    exec ./mvnw test
else
    echo "Executing command \"$*\""
    exec "$@"
fi
