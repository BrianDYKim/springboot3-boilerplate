package team.me.springtoolkit.validation

import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validation

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
open class SelfValidating<T : Any> {
    private val validator = Validation.buildDefaultValidatorFactory().validator

    protected fun validateSelf() {
        val violations = validator.validate(this)

        if (violations.isNotEmpty()) {
            throw ConstraintViolationException(violations)
        }
    }
}
