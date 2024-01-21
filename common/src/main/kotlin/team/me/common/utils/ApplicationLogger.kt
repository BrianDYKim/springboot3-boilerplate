package team.me.common.utils

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author Doyeop Kim
 * @since 2023/11/26
 */
abstract class ApplicationLogger(loggerName: String? = null) {
    val log: Logger =
        loggerName?.let {
            LoggerFactory.getLogger(it)
        } ?: if (this::class.isCompanion) {
            LoggerFactory.getLogger(this.javaClass.enclosingClass)
        } else {
            LoggerFactory.getLogger(this::class.java)
        }
}
