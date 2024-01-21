package team.me.common.validate

import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validation

/**
 * @author Brian
 * @since 1/19/24
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
