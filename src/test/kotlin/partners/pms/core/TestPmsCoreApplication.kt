package partners.pms.core

import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<PmsCoreApplication>().with(TestcontainersConfiguration::class).run(*args)
}
