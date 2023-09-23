# README

This repo contains a dummy and not working SpringBoot 3.1 service made to investigate how to reduce start up times
with techniques like context-indexer or AOT. 

## How to run
- `docker compose up fakeservice-standard` to run the service packaged in standard mode
- `docker compose up fakeservice-indexer` to run the service packaged using context-indexer
- `docker compose up fakeservice-aot` to run the service packaged using AOT on graalvm JDK

## How it's structured
This is a Kotlin service composed as a multi-module maven project:
- a `webapp` module that represent the entrypoint with a single REST controller
- a `core` module containing all the usecases, service and repos that the webapp can use

Each use cases uses all 5 available services, each service uses 2 of the 10 sub services, each subservice uses one of the 10 repos available.

Since we are interested in just boot times all the classes in the core module are dummy, without any working logic.
Not @Autowire annotations are used (just the @Repository annotation on repos). All the beans are defined in the `core` configuration. 
At the moment there are ~20 beans defined.

## How they are built
There is a docker-compose file that define a service for each of the 3 modes. Each service is tied to a specific dockerfile. 
- For the context-indexer compilation a dedicated profile `indexer-active` was added on the core pom.xml and the packaging is executed with the `-Pindexer-active` option
- For the aot compilation I've excluded the spring-boot-maven plugin from the `core` module using:
```xml
 <plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
    <configuration>
        <skip>true</skip>
    </configuration>
</plugin>
```
Otherwise, I receive an error that no main class is available (and it shouldn't since it's a library module).  
Packaging for aot is done using:  
`./mvnw clean compile spring-boot:process-aot package -pl webapp,core`  
and the jar is launched with  
`-Dspring.aot.enabled=true`

## Relevated startup times 
I'm using a 2020 MacBook PRO with a 2 GHz Quad-Core Intel Core i5 CPU, 16GB of RAM, 500GB SSD.

- for the standard mode boot times are pretty stable ~13secs
- for the indexer mode boot times are pretty stable ~8secs
- for the AOT mode I had times oscillating between 11 and 16secs, anyway 3 seconds worst then indexer. 






