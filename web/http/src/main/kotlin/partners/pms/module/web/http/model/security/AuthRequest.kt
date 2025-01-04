package partners.pms.module.web.http.model.security

data class AuthRequest(
    val username: String,
    val password: String,
)
