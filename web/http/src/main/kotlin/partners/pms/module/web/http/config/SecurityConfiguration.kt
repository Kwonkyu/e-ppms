package partners.pms.module.web.http.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import partners.pms.core.port.inbound.account.FindAccountPort
import partners.pms.module.web.http.security.LoadAccountService

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

    @Bean
    fun loadAccountService(findAccountPort: FindAccountPort): UserDetailsService = LoadAccountService(findAccountPort)

    @Bean
    fun daoAuthenticationProvider(
        userDetailsService: UserDetailsService,
        passwordEncoder: PasswordEncoder,
    ): DaoAuthenticationProvider {
        val daoAuthenticationProvider = DaoAuthenticationProvider()
        daoAuthenticationProvider.setUserDetailsService(userDetailsService)
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder)
        return daoAuthenticationProvider
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
}
