package partners.pms.application.service.account

import partners.pms.application.domain.account.Account
import partners.pms.core.port.inbound.account.model.AuthorizedAccount

class AccountFactory {
    object Outbound {
        fun toAuthorizedAccount(account: Account): AuthorizedAccount =
            AuthorizedAccount(
                username = account.username,
                password = account.password,
                name = account.name,
                email = account.email,
                phone = account.phone,
                status = account.status,
                isExpired = account.isExpired,
                roles = account.roles,
            )
    }
}
