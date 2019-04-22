# oil-distribution-project

Mini Enterprise Integration (EI) project, build with [Spring Boot](http://projects.spring.io/spring-boot/). This project consists of two applications an oil-distributor and gas-station, and with the help of few Enterprise Integration Messaging patterns, gas stations are informed when an oil distributor has updated their prices.

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `dk.kea.eric0101.gas_station_app.gaspricemanager.GasPriceManagerApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
