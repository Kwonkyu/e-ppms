@file:Suppress("ktlint:standard:no-wildcard-imports")

package partners.pms.module.persistence.rdb

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.core.context.SecurityContextHolder
import java.util.*

@Configuration
@ComponentScan(basePackages = ["partners.pms.module.persistence.rdb"])
@EntityScan(basePackages = ["partners.pms.module.persistence.rdb.entity"])
@EnableJpaRepositories(basePackages = ["partners.pms.module.persistence.rdb.repository"])
@EnableJpaAuditing
class PersistenceConfiguration {
    @Bean
    fun jpaQueryFactory(entityManager: EntityManager): JPAQueryFactory = JPAQueryFactory(entityManager)

    @Bean
    fun springSecurityAuditorAware(): AuditorAware<String> =
        AuditorAware<String> {
            Optional.of(SecurityContextHolder.getContext().authentication.name)
        }
}
