package partners.pms.module.persistence.rdb

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@ComponentScan(basePackages = ["partners.pms.module.persistence.rdb"])
@EntityScan(basePackages = ["partners.pms.module.persistence.rdb.entity"])
@EnableJpaRepositories(basePackages = ["partners.pms.module.persistence.rdb.repository"])
@EnableJpaAuditing
class PersistenceConfiguration
