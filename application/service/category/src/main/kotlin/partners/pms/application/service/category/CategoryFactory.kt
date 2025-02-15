package partners.pms.application.service.category

import partners.pms.application.domain.category.CommonCategory
import partners.pms.core.port.inbound.category.model.response.CreatedCategory

class CategoryFactory {
    object Outbound {
        fun toCreatedCategory(category: CommonCategory): CreatedCategory =
            CreatedCategory(
                code = category.code,
                name = category.name,
                description = category.description,
                parentCode = category.parent?.code,
                active = category.active,
            )
    }
}
