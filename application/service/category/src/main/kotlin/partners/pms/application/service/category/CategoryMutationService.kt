package partners.pms.application.service.category

import org.springframework.transaction.annotation.Transactional
import partners.pms.application.domain.category.DisplayCategory
import partners.pms.application.domain.category.ProductCategory
import partners.pms.common.partners.pms.common.enum.CategoryType
import partners.pms.core.port.inbound.category.model.request.CategoryCreateRequest
import partners.pms.core.port.inbound.category.model.response.CreatedCategory
import partners.pms.core.port.inbound.category.CreateCategoryPort as CreateCategoryEndpointPort
import partners.pms.core.port.outbound.category.CreateCategoryPort as CreateCategoryPersistencePort
import partners.pms.core.port.outbound.category.FindCategoryPort as FindCategoryPersistencePort

@Transactional
class CategoryMutationService(
    private val findCategoryPort: FindCategoryPersistencePort,
    private val createCategoryPort: CreateCategoryPersistencePort,
) : CreateCategoryEndpointPort {
    override fun createCategory(request: CategoryCreateRequest): CreatedCategory {
        if (findCategoryPort.existsByCode(request.code)) {
            throw IllegalArgumentException("Category code already exists")
        }
        val createdCategory =
            when (request.type) {
                CategoryType.DISPLAY -> {
                    val parent =
                        request.parentCode?.let {
                            findCategoryPort.findDisplayCategoryBy(code = it)
                                ?: throw IllegalArgumentException("Parent category not found")
                        }
                    val category =
                        DisplayCategory(
                            code = request.code,
                            name = request.name,
                            description = request.description,
                            parent = parent,
                            active = request.active,
                            sort = request.sort,
                        )
                    createCategoryPort.create(category)
                }
                CategoryType.PRODUCT -> {
                    val parent =
                        request.parentCode?.let {
                            findCategoryPort.findProductCategoryBy(code = it)
                                ?: throw IllegalArgumentException("Parent category not found")
                        }
                    val category =
                        ProductCategory(
                            code = request.code,
                            name = request.name,
                            description = request.description,
                            parent = parent,
                            active = request.active,
                            sort = request.sort,
                        )
                    createCategoryPort.create(category)
                }
            }

        return CategoryFactory.Outbound.toCreatedCategory(createdCategory)
    }
}
