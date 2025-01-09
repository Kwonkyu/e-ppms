package partners.pms.application.service.account

import partners.pms.application.domain.account.Account
import partners.pms.common.getCurrentSeoulTime
import partners.pms.core.port.inbound.account.model.AuthorizedAccount
import partners.pms.core.port.inbound.account.model.request.AccountCreateRequest

class AccountFactory {
    object Inbound {
        fun fromCreateRequest(request: AccountCreateRequest): Account =
            Account(
                username = request.username,
                password = request.password,
                name = request.name,
                email = request.email,
                phone = request.phone,
                validFrom = getCurrentSeoulTime(),
                validUntil = getCurrentSeoulTime(),
            )
    }

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
