package team.me.external

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ExternalApplication

fun main(args: Array<String>) {
    runApplication<ExternalApplication>(*args)
}
