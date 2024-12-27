package partners.pms.module.web.http

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackages = ["partners.web.http.controller"])
class RestControllerConfiguration
