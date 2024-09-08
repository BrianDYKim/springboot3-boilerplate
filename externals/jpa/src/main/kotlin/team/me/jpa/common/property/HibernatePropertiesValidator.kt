package team.me.jpa.common.property

import org.springframework.stereotype.Component

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
@Component
class HibernatePropertiesValidator {
    companion object {
        const val PRODUCTION_PROFILE_NAME = "prod"
        const val STAGE_PROFILE_NAME = "stage"
        const val DEV_PROFILE_NAME = "dev"

        private var springJpaHibernateDdlAutoPropertyName = HibernateProperties.HIBERNATE_DDL_AUTO.key
        private var springJpaHibernateHbm2ddlAutoPropertyName = HibernateProperties.HIBERNATE_HBM2DDL_AUTO.key

        val VALIDATION_PROPERTY_NAMES =
            listOf(springJpaHibernateDdlAutoPropertyName, springJpaHibernateHbm2ddlAutoPropertyName)
    }

    fun validate(properties: Map<String, String>) {
        VALIDATION_PROPERTY_NAMES.forEach { propertyName ->
            val propertyValue = properties[propertyName]

            if (checkInvalidPropertyValue(propertyValue)) {
                val errorMessage =
                    "In production profile, $propertyName : $propertyValue must be set to none. Other values are disallowed."

                throw IllegalArgumentException(errorMessage)
            }
        }
    }

    private fun checkInvalidPropertyValue(propertyValue: String?): Boolean {
        return propertyValue != null && "none" != propertyValue
    }
}
