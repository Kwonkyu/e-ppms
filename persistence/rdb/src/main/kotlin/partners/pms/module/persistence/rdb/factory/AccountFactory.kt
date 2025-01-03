package partners.pms.module.persistence.rdb.factory

import partners.pms.application.domain.account.Account
import java.time.ZonedDateTime
import partners.pms.module.persistence.rdb.entity.Account as AccountEntity

class AccountFactory {
    object ToDomain {
        fun fromEntity(accountEntity: AccountEntity): Account =
            Account(
                username = accountEntity.username,
                password = accountEntity.password,
                email = accountEntity.email,
                name = accountEntity.name,
                role = accountEntity.role,
                validFrom = ZonedDateTime.now(), // accountEntity.validFrom,
                validUntil = ZonedDateTime.now(), // accountEntity.validUntil,
                type = "ACCOUNT_TYPE", // accountEntity.type,
                status = "ACCOUNT_STATUS", // accountEntity.status
            )
    }
}
