package partners.pms.module.web.http.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.server.ServletServerHttpResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint

class Fake404AuthorizationDeniedHandler : AuthenticationEntryPoint {
    private val converter: HttpMessageConverter<Any> = MappingJackson2HttpMessageConverter()

    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException,
    ) {
        response.status = HttpServletResponse.SC_NOT_FOUND
        converter.write(
            "Authentication... Not Found?",
            MediaType.APPLICATION_JSON,
            ServletServerHttpResponse(response),
        )
    }
}
