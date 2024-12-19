package partners.pms.core

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.RabbitMQContainer
import org.testcontainers.kafka.KafkaContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {
    @Bean
    @ServiceConnection
    fun kafkaContainer(): KafkaContainer = KafkaContainer(DockerImageName.parse("apache/kafka-native:3.8.1"))

    @Bean
    @ServiceConnection
    fun mongoDbContainer(): MongoDBContainer = MongoDBContainer(DockerImageName.parse("mongo:latest"))

    @Bean
    @ServiceConnection
    fun postgresContainer(): PostgreSQLContainer<*> = PostgreSQLContainer(DockerImageName.parse("postgres:latest"))

    @Bean
    @ServiceConnection
    fun rabbitContainer(): RabbitMQContainer = RabbitMQContainer(DockerImageName.parse("rabbitmq:latest"))

    @Bean
    @ServiceConnection(name = "redis")
    fun redisContainer(): GenericContainer<*> = GenericContainer(DockerImageName.parse("redis:latest")).withExposedPorts(6379)
}
