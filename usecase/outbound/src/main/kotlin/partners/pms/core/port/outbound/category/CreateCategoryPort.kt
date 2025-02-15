package partners.pms.core.port.outbound.category

import partners.pms.application.domain.category.DisplayCategory
import partners.pms.application.domain.category.ProductCategory

interface CreateCategoryPort {
    fun create(category: DisplayCategory): DisplayCategory

    fun create(category: ProductCategory): ProductCategory
}
