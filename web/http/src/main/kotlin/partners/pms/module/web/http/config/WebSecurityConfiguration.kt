package partners.pms.module.web.http.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler
import partners.pms.core.port.inbound.account.FindAccountPort
import partners.pms.module.web.http.security.JsonUsernamePasswordAuthenticationFilter
import partners.pms.module.web.http.security.LoadAccountService

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration {
    @Bean
    fun securityFilterChain(
        http: HttpSecurity,
        authenticationManager: AuthenticationManager,
    ): SecurityFilterChain =
        http
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers("/actuator/**").permitAll()
                it.anyRequest().authenticated()
                // it.requestMatchers("/product/**").access( /** auth manager here? */)
            }.logout {
                it.permitAll()
                it.logoutSuccessHandler(HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK))
            }.addFilterBefore(
                JsonUsernamePasswordAuthenticationFilter(authenticationManager),
                UsernamePasswordAuthenticationFilter::class.java,
            ).build()

    @Bean
    fun authenticationManager(authenticationConfiguration: AuthenticationConfiguration): AuthenticationManager =
        authenticationConfiguration.authenticationManager

    @Bean
    fun loadAccountService(findAccountPort: FindAccountPort): UserDetailsService = LoadAccountService(findAccountPort)

    @Bean
    fun passwordEncoder(): PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
}
