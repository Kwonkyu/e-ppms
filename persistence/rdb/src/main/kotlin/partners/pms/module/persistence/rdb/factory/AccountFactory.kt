package partners.pms.module.persistence.rdb.factory

import partners.pms.application.domain.account.Account
import partners.pms.module.persistence.rdb.entity.AccountAuthority
import partners.pms.module.persistence.rdb.entity.AccountAuthorityPK
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
                validFrom = accountEntity.validFrom,
                validUntil = accountEntity.validUntil,
                roles = accountEntity.authorities.mapTo(mutableSetOf()) { it.id.role },
            )
    }

    object ToEntity {
        fun fromDomain(account: Account): AccountEntity {
            val createdEntity =
                AccountEntity(
                    username = account.username,
                    password = account.password,
                    name = account.name,
                    email = account.email,
                    phone = account.phone,
                    status = account.status,
                    validFrom = account.validFrom,
                    validUntil = account.validUntil,
                    authorities = mutableSetOf(),
                )
            val authorities = mutableSetOf<AccountAuthority>()
            for (role in account.roles) {
                val pk = AccountAuthorityPK(account = createdEntity, role = role)
                authorities.add(AccountAuthority(pk))
            }
            return createdEntity.apply { this.authorities = authorities }
        }
    }
}
