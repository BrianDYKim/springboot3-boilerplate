package team.me.jpa.common.property

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
enum class HibernateProperties(val key: String, val defaultValue: String) {
    HIBERNATE_FORMAT_SQL("hibernate.format_sql", "true"),
    HIBERNATE_HIGHLIGHT_SQL("hibernate.highlight.sql", "true"),
    HIBERNATE_HBM2DDL_AUTO("hibernate.hbm2ddl-auto", "none"),
    HIBERNATE_DDL_AUTO("hibernate.ddl-auto", "none"),
    HIBERNATE_DIALECT("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect"),
}
