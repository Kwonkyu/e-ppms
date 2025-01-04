package partners.pms.module.web.http.model.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AccountDetails(
    private val username: String,
    private val password: String,
    val name: String,
    val type: String,
    val status: String,
    val role: String,
    val email: String,
    val isExpired: Boolean,
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        // TODO
        return mutableListOf()
    }

    override fun getPassword(): String = password

    override fun getUsername(): String = username
}
