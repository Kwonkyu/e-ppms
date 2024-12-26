package partners.persistenceredis

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PersistenceRedisApplication

fun main(args: Array<String>) {
    runApplication<PersistenceRedisApplication>(*args)
}
