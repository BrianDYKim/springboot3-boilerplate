package team.me.common.manager

class AbstractManager<K, V>(private val defaultDriver: K, defaultDependency: V) {
    private val dependencyMap: MutableMap<K, V> = mutableMapOf()

    init {
        dependencyMap[defaultDriver] = defaultDependency
    }

    fun register(
        key: K,
        dependency: V,
    ): AbstractManager<K, V> {
        dependencyMap[key] = dependency
        return this
    }

    fun get(key: K): V {
        return when (dependencyMap.contains(key)) {
            true -> dependencyMap[key]!!
            false -> dependencyMap[defaultDriver]!!
        }
    }
}
