package team.me.jpa.config.dataSource.fundamental

import jakarta.persistence.EntityManagerFactory
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
interface DataSourceConfigurationContract {
    fun writeDataSource(): DataSource

    fun readDataSource(): DataSource

    fun routingDataSource(
        writeDataSource: DataSource,
        readDataSource: DataSource,
    ): DataSource

    fun entityManagerFactory(
        builder: EntityManagerFactoryBuilder,
        dataSource: DataSource,
    ): LocalContainerEntityManagerFactoryBean

    fun transactionManager(entityManagerFactory: EntityManagerFactory): PlatformTransactionManager
}
