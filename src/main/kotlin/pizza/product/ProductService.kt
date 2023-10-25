package pizza.product

import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

    /**
     * Returns the [Product] found or throws [ProductNotFoundException] if not
     * @throws ProductNotFoundException
     */
    fun getProduct(productId: String): Product =
        productRepository.findById(productId)
            .orElseThrow { ProductNotFoundException("for id $productId") }


    fun createProduct(product: Product) {
        if (product.productId.isNullOrBlank()) {
            product.productId = UUID.randomUUID().toString()
        }
        productRepository.save(product)
    }


    fun getTotalPrice(productQuantities: Map<String, Int>): Double {
        // loop over each map entry (which is productId -> quantity) and map each entry to the product's price
        // multiplied by desired quantity. Then sum all up and that is our total.
        // To avoid annoying floating point arithmetic problems we calculate everything in cent and divide later
        // back to full Euro.
        val totalPriceInCent = productQuantities
            .map { entry ->
                val product = getProduct(entry.key)
                (product.price * entry.value * 100).toInt()
            }
            .sum()
        return totalPriceInCent / 100.0
    }

}