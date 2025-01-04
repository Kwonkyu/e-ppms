package partners.pms

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PmsCoreApplication

fun main(args: Array<String>) {
    runApplication<PmsCoreApplication>(*args)
}
