package team.me.common

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * @author Doyeop Kim
 * @since 2023/11/26
 */
@SpringBootApplication(scanBasePackages = ["team.me"])
class CommonApplication

fun main(args: Array<String>) {
    runApplication<CommonApplication>(*args)
}
