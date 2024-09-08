package team.me.jpa.mainDataSource.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import team.me.jpa.common.entity.BaseJpaEntity

/**
 * @author Doyeop Kim
 * @since 2024. 9. 8.
 */
@Entity
@Table(name = "users")
open class UserJpaEntity protected constructor() : BaseJpaEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    open var id: Long? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserJpaEntity) return false

        return id == other.id
    }

    override fun hashCode(): Int = id?.hashCode() ?: 0
}
