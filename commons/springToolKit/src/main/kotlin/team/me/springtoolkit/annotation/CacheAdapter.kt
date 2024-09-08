package team.me.springtoolkit.annotation

import org.springframework.core.annotation.AliasFor
import org.springframework.stereotype.Repository

@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Repository
annotation class CacheAdapter(
    @get:AliasFor(annotation = Repository::class, attribute = "value")
    val value: String = "",
)
