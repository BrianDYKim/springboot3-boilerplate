package team.me.jpa.config.dataSource.aspect

import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import team.me.jpa.common.annotation.MainDataSourceTransactional
import team.me.jpa.config.dataSource.fundamental.DataSourceContextHolder
import team.me.jpa.config.dataSource.fundamental.DataSourceTypes

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
@Aspect
@Component
@Order(0)
class DataSourceAspect {
    @Before("@annotation(mainDataSourceTransactional)")
    fun setMainDataSource(mainDataSourceTransactional: MainDataSourceTransactional) {
        if (mainDataSourceTransactional.readOnly) {
            DataSourceContextHolder.setDataSourceType(DataSourceTypes.MAIN_READ)
        } else {
            DataSourceContextHolder.setDataSourceType(DataSourceTypes.MAIN_WRITE)
        }
    }
}
