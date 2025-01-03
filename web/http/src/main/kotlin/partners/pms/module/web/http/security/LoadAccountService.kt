package partners.pms.module.web.http.security

import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import partners.pms.core.port.inbound.account.FindAccountPort
import partners.pms.module.web.http.model.security.AccountDetails

class LoadAccountService(
    private val findAccountPort: FindAccountPort,
) : UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        if (username == null) throw UsernameNotFoundException("Username is null")
        return findAccountPort
            .findAccountDetail(username)
            ?.let {
                AccountDetails(
                    username = it.username,
                    password = it.password,
                    name = it.name,
                    type = it.type,
                    status = it.status,
                    role = it.role,
                    email = "E_MAIL@PPMS.COM",
                    isExpired = false,
                )
                // 절대로 null 을 반환하지 않도록 인터페이스에 정의되어 있음
            } ?: throw UsernameNotFoundException("Username is null")
    }
}
