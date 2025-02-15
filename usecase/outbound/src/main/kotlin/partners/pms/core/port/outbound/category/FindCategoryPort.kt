package partners.pms.core.port.outbound.category

import partners.pms.application.domain.category.DisplayCategory
import partners.pms.application.domain.category.ProductCategory

interface FindCategoryPort {
    fun findProductCategoryBy(
        id: Long? = null,
        code: String? = null,
        name: String? = null,
    ): ProductCategory?

    fun findDisplayCategoryBy(
        id: Long? = null,
        code: String? = null,
        name: String? = null,
    ): DisplayCategory?

    fun existsByCode(code: String): Boolean
}
