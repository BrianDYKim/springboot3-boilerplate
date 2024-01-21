package team.me.adminapi

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.ApplicationContext

@SpringBootApplication
class AdminApiApplication {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val applicationContext: ApplicationContext = SpringApplication.run(AdminApiApplication::class.java, *args)
        }
    }
}
