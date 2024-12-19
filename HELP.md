# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.4.0/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.4.0/gradle-plugin/packaging-oci-image.html)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/3.4.0/reference/testing/testcontainers.html#testing.testcontainers)
* [Testcontainers RabbitMQ Module Reference Guide](https://java.testcontainers.org/modules/rabbitmq/)
* [Testcontainers MongoDB Module Reference Guide](https://java.testcontainers.org/modules/databases/mongodb/)
* [Testcontainers Kafka Modules Reference Guide](https://java.testcontainers.org/modules/kafka/)
* [Testcontainers Postgres Module Reference Guide](https://java.testcontainers.org/modules/databases/postgres/)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/3.4.0/reference/using/devtools.html)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/3.4.0/specification/configuration-metadata/annotation-processor.html)
* [Docker Compose Support](https://docs.spring.io/spring-boot/3.4.0/reference/features/dev-services.html#features.dev-services.docker-compose)
* [Spring Web](https://docs.spring.io/spring-boot/3.4.0/reference/web/servlet.html)
* [Spring Session](https://docs.spring.io/spring-session/reference/)
* [Spring Security](https://docs.spring.io/spring-boot/3.4.0/reference/web/spring-security.html)
* [JDBC API](https://docs.spring.io/spring-boot/3.4.0/reference/data/sql.html)
* [Spring Data JPA](https://docs.spring.io/spring-boot/3.4.0/reference/data/sql.html#data.sql.jpa-and-spring-data)
* [Liquibase Migration](https://docs.spring.io/spring-boot/3.4.0/how-to/data-initialization.html#howto.data-initialization.migration-tool.liquibase)
* [MyBatis Framework](https://mybatis.org/spring-boot-starter/mybatis-spring-boot-autoconfigure/)
* [Spring Data Redis (Access+Driver)](https://docs.spring.io/spring-boot/3.4.0/reference/data/nosql.html#data.nosql.redis)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/3.4.0/reference/data/nosql.html#data.nosql.mongodb)
* [Spring for RabbitMQ](https://docs.spring.io/spring-boot/3.4.0/reference/messaging/amqp.html)
* [Spring for Apache Kafka](https://docs.spring.io/spring-boot/3.4.0/reference/messaging/kafka.html)
* [Quartz Scheduler](https://docs.spring.io/spring-boot/3.4.0/reference/io/quartz.html)
* [Spring Cache Abstraction](https://docs.spring.io/spring-boot/3.4.0/reference/io/caching.html)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/3.4.0/reference/actuator/index.html)
* [Prometheus](https://docs.spring.io/spring-boot/3.4.0/reference/actuator/metrics.html#actuator.metrics.export.prometheus)
* [Testcontainers](https://java.testcontainers.org/)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [MyBatis Quick Start](https://github.com/mybatis/spring-boot-starter/wiki/Quick-Start)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)
* [Messaging with RabbitMQ](https://spring.io/guides/gs/messaging-rabbitmq/)
* [Caching Data with Spring](https://spring.io/guides/gs/caching/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* mongodb: [`mongo:latest`](https://hub.docker.com/_/mongo)
* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)
* rabbitmq: [`rabbitmq:latest`](https://hub.docker.com/_/rabbitmq)
* redis: [`redis:latest`](https://hub.docker.com/_/redis)

Please review the tags of the used images and set them to the same as you're running in production.

### Testcontainers support

This project uses [Testcontainers at development time](https://docs.spring.io/spring-boot/3.4.0/reference/features/dev-services.html#features.dev-services.testcontainers).

Testcontainers has been configured to use the following Docker images:

* [`apache/kafka-native:latest`](https://hub.docker.com/r/apache/kafka-native)
* [`mongo:latest`](https://hub.docker.com/_/mongo)
* [`postgres:latest`](https://hub.docker.com/_/postgres)
* [`rabbitmq:latest`](https://hub.docker.com/_/rabbitmq)
* [`redis:latest`](https://hub.docker.com/_/redis)

Please review the tags of the used images and set them to the same as you're running in production.

