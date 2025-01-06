package partners.pms.module.web.http.model.security

import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AccountDetails(
    private val username: String,
    private val password: String,
    val name: String,
    val type: String,
    val status: String,
    val email: String,
    val isExpired: Boolean,
    val authorities: MutableSet<out GrantedAuthority>,
) : UserDetails {
    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = authorities

    override fun getPassword(): String = password

    override fun getUsername(): String = username
}
