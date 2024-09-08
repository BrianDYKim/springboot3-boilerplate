package team.me.jpa.common.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.transaction.annotation.Transactional

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Transactional
annotation class MainDataSourceTransactional(
    @get:AliasFor(annotation = Transactional::class, attribute = "readOnly")
    val readOnly: Boolean = false,
)
