package partners.pms.module.web.http.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfiguration {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain =
        http
            .authorizeHttpRequests {
                it.requestMatchers("/**").permitAll()
//                it.requestMatchers("/actuator/**").permitAll()
                // it.requestMatchers("/product/**").access( /** auth manager here? */)
//                it.requestMatchers("/product/**").permitAll()
                it.anyRequest().authenticated()
            }
            // .cors() << not default anymore?
            .csrf { it.disable() }
            .formLogin { it.permitAll() }
            .build()
}
