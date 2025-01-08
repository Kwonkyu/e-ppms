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
                name = accountEntity.name,
                email = accountEntity.email,
                phone = accountEntity.phone,
                status = accountEntity.status,
                validFrom = ZonedDateTime.now(), // accountEntity.validFrom,
                validUntil = ZonedDateTime.now(), // accountEntity.validUntil,
                roles = accountEntity.authorities.mapTo(mutableSetOf()) { it.id.role },
            )
    }
}
