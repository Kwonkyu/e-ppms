package partners.pms.module.web.http.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.server.ServletServerHttpResponse
import org.springframework.security.core.Authentication
import org.springframework.security.web.authentication.AuthenticationSuccessHandler

class JsonLoginSuccessHandler : AuthenticationSuccessHandler {
    private val converter: HttpMessageConverter<Any> = MappingJackson2HttpMessageConverter()

    override fun onAuthenticationSuccess(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authentication: Authentication,
    ) {
        converter.write(
            AuthenticationSuccess(
                username = authentication.name,
                authenticated = authentication.isAuthenticated,
                session = request.session.id,
            ),
            MediaType.APPLICATION_JSON,
            ServletServerHttpResponse(response),
        )
    }

    class AuthenticationSuccess(
        val username: String,
        val authenticated: Boolean,
        val session: String,
    )
}
