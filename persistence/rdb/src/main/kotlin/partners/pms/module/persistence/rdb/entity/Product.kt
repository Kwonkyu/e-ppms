@file:Suppress("ktlint:standard:no-wildcard-imports")

package partners.pms.module.persistence.rdb.entity

import jakarta.persistence.*

@Entity
class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "code")
    var code: String,
    @Column(name = "name")
    var name: String,
    @Column(name = "price")
    var price: Double,
) : Auditable()
