package partners.pms.core.port.inbound.category

import partners.pms.core.port.inbound.category.model.request.CategoryCreateRequest
import partners.pms.core.port.inbound.category.model.response.CreatedCategory

interface CreateCategoryPort {
    /**
     * 새로운 상품 카테고리를 생성합니다.
     * @param request 상품 카테고리 생성 요청
     * @return 생성된 상품 카테고리 모델
     */
    fun createCategory(request: CategoryCreateRequest): CreatedCategory
}
