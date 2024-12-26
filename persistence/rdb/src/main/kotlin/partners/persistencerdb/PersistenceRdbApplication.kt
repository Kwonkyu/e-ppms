package partners.persistencerdb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PersistenceRdbApplication

fun main(args: Array<String>) {
    runApplication<PersistenceRdbApplication>(*args)
}
