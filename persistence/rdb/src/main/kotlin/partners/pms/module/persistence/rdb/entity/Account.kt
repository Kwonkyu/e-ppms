@file:Suppress("ktlint:standard:no-wildcard-imports")

package partners.pms.module.persistence.rdb.entity

import jakarta.persistence.*

@Entity
class Account(
    @Id
    @Column(name = "username")
    var username: String,
    @Column(name = "password")
    var password: String,
    @Column(name = "name")
    var name: String,
    @Column(name = "email")
    var email: String,
    @Column(name = "phone")
    var phone: String,
    @Column(name = "status")
    var status: String,
    @OneToMany(mappedBy = "id.account", orphanRemoval = true, fetch = FetchType.LAZY)
    var authorities: MutableSet<AccountAuthority>,
) : Auditable()
