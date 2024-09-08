package team.me.jpa.config.dataSource.fundamental

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
enum class DataSourceTypes(val dataSourceKey: String) {
    MAIN_WRITE("MAIN_WRITE"),
    MAIN_READ("MAIN_READ"),
}
