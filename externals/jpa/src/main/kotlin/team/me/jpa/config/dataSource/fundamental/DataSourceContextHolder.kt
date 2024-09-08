package team.me.jpa.config.dataSource.fundamental

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
object DataSourceContextHolder {
    private val contextHolder = ThreadLocal<DataSourceTypes>()

    init {
        setDataSourceType(DataSourceTypes.MAIN_WRITE) // 초기값 설정
    }

    fun setDataSourceType(dataSourceType: DataSourceTypes) {
        contextHolder.set(dataSourceType)
    }

    fun getDataSourceType(): DataSourceTypes {
        return contextHolder.get()
    }

    fun clearDataSourceType() {
        contextHolder.remove()
    }
}
