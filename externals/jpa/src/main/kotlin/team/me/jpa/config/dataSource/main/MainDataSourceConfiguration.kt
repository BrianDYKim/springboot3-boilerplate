package team.me.jpa.config.dataSource.main

import jakarta.persistence.EntityManagerFactory
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import team.me.jpa.common.property.HibernatePropertiesValidator
import team.me.jpa.common.property.HibernatePropertyFactory
import team.me.jpa.config.dataSource.fundamental.DataSourceConfigurationContract
import team.me.jpa.config.dataSource.fundamental.DataSourceTypes
import team.me.jpa.config.dataSource.fundamental.RoutingDataSource
import javax.sql.DataSource

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
@Configuration
class MainDataSourceConfiguration(
    private val hibernatePropertyFactory: HibernatePropertyFactory,
    private val hibernatePropertiesValidator: HibernatePropertiesValidator,
    @Value("\${spring.datasource.main.write.url}") private val writeUrl: String,
    @Value("\${spring.datasource.main.write.username}") private val writeUsername: String,
    @Value("\${spring.datasource.main.write.password}") private val writePassword: String,
    @Value("\${spring.datasource.main.read.url}") private val readUrl: String,
    @Value("\${spring.datasource.main.read.username}") private val readUsername: String,
    @Value("\${spring.datasource.main.read.password}") private val readPassword: String,
    @Value("\${spring.datasource.main.driver-class-name}") private val driverClassName: String,
) : DataSourceConfigurationContract {
    companion object {
        const val PACKAGE_SCAN_COVERAGE = "team.me.jpa.mainDataSource"
    }

    init {
        val hibernatePropertiesMap = hibernatePropertyFactory.getPropertiesMap()
        hibernatePropertiesValidator.validate(hibernatePropertiesMap)
    }

    @Bean(name = ["mainWriteDataSource"])
    override fun writeDataSource(): DataSource {
        return DataSourceBuilder.create()
            .url(writeUrl)
            .username(writeUsername)
            .password(writePassword)
            .driverClassName(driverClassName)
            .build()
    }

    @Bean(name = ["mainReadDataSource"])
    override fun readDataSource(): DataSource {
        return DataSourceBuilder.create()
            .url(readUrl)
            .username(readUsername)
            .password(readPassword)
            .driverClassName(driverClassName)
            .build()
    }

    @Primary
    @Bean(name = ["mainRoutingDataSource"])
    override fun routingDataSource(
        @Qualifier("mainWriteDataSource") writeDataSource: DataSource,
        @Qualifier("mainReadDataSource") readDataSource: DataSource,
    ): DataSource {
        val dataSourceMap = HashMap<Any, Any>()

        val writeDataSourceKey = DataSourceTypes.MAIN_WRITE.dataSourceKey
        dataSourceMap[writeDataSourceKey] = writeDataSource

        val readDataSourceKey = DataSourceTypes.MAIN_READ.dataSourceKey
        dataSourceMap[readDataSourceKey] = readDataSource

        val mainRoutingDataSource = RoutingDataSource()
        mainRoutingDataSource.setDefaultTargetDataSource(writeDataSource)
        mainRoutingDataSource.setTargetDataSources(dataSourceMap)

        return mainRoutingDataSource
    }

    @Bean(name = ["mainEntityManagerFactory"])
    override fun entityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        @Qualifier("mainRoutingDataSource") dataSource: DataSource,
    ): LocalContainerEntityManagerFactoryBean {
        val properties = hibernatePropertyFactory.getPropertiesMap()

        return builder
            .dataSource(dataSource)
            .packages(PACKAGE_SCAN_COVERAGE)
            .persistenceUnit("main")
            .properties(properties)
            .build()
    }

    @Bean(name = ["mainTransactionManager"])
    override fun transactionManager(
        @Qualifier("mainEntityManagerFactory") entityManagerFactory: EntityManagerFactory,
    ): PlatformTransactionManager {
        return JpaTransactionManager(entityManagerFactory)
    }
}
