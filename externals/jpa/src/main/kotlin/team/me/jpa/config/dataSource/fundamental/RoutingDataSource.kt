package team.me.jpa.config.dataSource.fundamental

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
class RoutingDataSource : AbstractRoutingDataSource() {
    override fun determineCurrentLookupKey(): String {
        return DataSourceContextHolder.getDataSourceType().dataSourceKey
    }
}
