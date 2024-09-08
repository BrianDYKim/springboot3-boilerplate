package team.me.jpa.common.entity

import jakarta.persistence.MappedSuperclass

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
@MappedSuperclass
abstract class BaseJpaEntity {
    abstract override fun equals(other: Any?): Boolean

    abstract override fun hashCode(): Int
}
