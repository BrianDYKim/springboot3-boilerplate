package team.me.common.manager

class AbstractManager<K, V> private constructor() {
    private val dependencyMap: MutableMap<K, V> = mutableMapOf()

    /**
     * get the dependency from the manager
     */
    fun get(key: K): V? {
        return dependencyMap[key]
    }

    class Builder<K, V> {
        private val manager = AbstractManager<K, V>()

        fun register(
            key: K,
            value: V,
        ): Builder<K, V> {
            manager.dependencyMap[key] = value
            return this
        }

        fun build(): AbstractManager<K, V> {
            return manager
        }
    }
}
