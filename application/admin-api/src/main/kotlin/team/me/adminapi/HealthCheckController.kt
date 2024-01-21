package team.me.adminapi

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @author Doyeop Kim
 * @since 2023/11/26
 */
@RestController
class HealthCheckController {
    @GetMapping("/health")
    fun healthCheck(): String {
        return "health"
    }
}
