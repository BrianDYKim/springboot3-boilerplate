package team.me.common.annotations.platform

import javax.annotation.Nonnull
import javax.annotation.meta.TypeQualifierNickname
import javax.annotation.meta.When

/**
 * JAVA 기반 API의 Nullable 안정성을 추가하기 위한 코틀린 커스텀 어노테이션
 * @author Doyeop Kim
 * @since 2024/01/21
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FIELD, AnnotationTarget.TYPE)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Nonnull(`when` = When.MAYBE)
@TypeQualifierNickname
annotation class BrianNullable
