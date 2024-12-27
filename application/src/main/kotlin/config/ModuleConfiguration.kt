package partners.pms.core.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["partners.pms.module"])
class ModuleConfiguration
