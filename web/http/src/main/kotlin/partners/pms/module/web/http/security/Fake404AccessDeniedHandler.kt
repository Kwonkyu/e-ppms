package partners.pms.module.web.http.security

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.http.server.ServletServerHttpResponse
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler

class Fake404AccessDeniedHandler : AccessDeniedHandler {
    private val converter: HttpMessageConverter<Any> = MappingJackson2HttpMessageConverter()

    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: AccessDeniedException,
    ) {
        response.status = HttpServletResponse.SC_NOT_FOUND
        converter.write(
            "Access... Not Found?",
            MediaType.APPLICATION_JSON,
            ServletServerHttpResponse(response),
        )
    }
}
