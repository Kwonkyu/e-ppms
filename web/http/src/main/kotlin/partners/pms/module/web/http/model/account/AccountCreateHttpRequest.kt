package partners.pms.module.web.http.model.account

data class AccountCreateHttpRequest(
    val username: String,
    val password: String,
    val name: String,
    val email: String,
    val phone: String,
)
