package pizza.product

import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    fun getProduct(productId: String) : Product =
        productRepository.findById(productId)
            .orElseThrow { ProductNotFoundException("for id $productId") }


    fun createProduct(product: Product) {
        if (product.productId.isNullOrBlank()) {
            product.productId = UUID.randomUUID().toString()
        }
        productRepository.save(product)
    }

}