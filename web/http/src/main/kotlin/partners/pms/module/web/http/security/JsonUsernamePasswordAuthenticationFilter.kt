package partners.pms.module.web.http.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import partners.pms.module.web.http.model.security.AuthRequest

class JsonUsernamePasswordAuthenticationFilter(
    authenticationManager: AuthenticationManager,
) : AbstractAuthenticationProcessingFilter(
        AntPathRequestMatcher("/login", "POST", true),
        authenticationManager,
    ) {
    init {
        setAuthenticationSuccessHandler(JsonLoginSuccessHandler())
    }

    override fun attemptAuthentication(
        request: HttpServletRequest?,
        response: HttpServletResponse?,
    ): Authentication {
        val authRequest =
            request?.reader.let {
                val loginRequest = jsonReader.readValue(it, AuthRequest::class.java)
                val username = loginRequest.username
                val password = loginRequest.password
                UsernamePasswordAuthenticationToken(username, password)
            }
        logger.info("authRequest: $authRequest")
        return authenticationManager.authenticate(authRequest)
    }

    private val jsonReader = ObjectMapper().registerKotlinModule()
}
