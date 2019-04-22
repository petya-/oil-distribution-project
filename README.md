# oil-distribution-project

Mini Enterprise Integration (EI) project, build with [Spring Boot](http://projects.spring.io/spring-boot/). This project consists of two applications an oil-distributor and gas-station, and with the help of few Enterprise Integration Messaging patterns, gas stations are informed when an oil distributor has updated their prices.

## Integration patterns used

- [Messaging integration pattern](https://www.enterpriseintegrationpatterns.com/patterns/messaging/Messaging.html)
- [Message Endpoint](https://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageEndpoint.html)
- [Message](https://www.enterpriseintegrationpatterns.com/patterns/messaging/Message.html)
- [Message Broker](https://www.enterpriseintegrationpatterns.com/patterns/messaging/MessageBroker.html)
- [Publish/Subcribe Channel](https://www.enterpriseintegrationpatterns.com/patterns/messaging/PublishSubscribeChannel.html)

## Technologies used

- [Java Message Service](https://www.oracle.com/technetwork/articles/java/introjms-1577110.html)
- [ActiveMQ](http://activemq.apache.org/)
- [Spring Boot](https://spring.io/projects/spring-boot)

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
