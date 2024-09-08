package team.me.jpa.common.property

import org.springframework.stereotype.Component

@Component
class HibernatePropertyFactory {
    fun getPropertiesMap(): Map<String, String> {
        val properties = mutableMapOf<String, String>()

        properties[HibernateProperties.HIBERNATE_FORMAT_SQL.key] = HibernateProperties.HIBERNATE_FORMAT_SQL.defaultValue
        properties[HibernateProperties.HIBERNATE_HIGHLIGHT_SQL.key] = HibernateProperties.HIBERNATE_HIGHLIGHT_SQL.defaultValue
        properties[HibernateProperties.HIBERNATE_HBM2DDL_AUTO.key] = HibernateProperties.HIBERNATE_HBM2DDL_AUTO.defaultValue
        properties[HibernateProperties.HIBERNATE_DDL_AUTO.key] = HibernateProperties.HIBERNATE_DDL_AUTO.defaultValue
        properties[HibernateProperties.HIBERNATE_DIALECT.key] = HibernateProperties.HIBERNATE_DIALECT.defaultValue

        return properties
    }
}
