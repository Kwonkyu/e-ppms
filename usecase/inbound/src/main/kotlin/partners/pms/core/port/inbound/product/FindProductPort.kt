package partners.pms.core.port.inbound.product

import partners.pms.core.port.inbound.product.model.response.SearchedProduct

interface FindProductPort {
    fun findByCode(code: String): SearchedProduct?
}
