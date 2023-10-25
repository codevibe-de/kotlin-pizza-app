package pizza.product

import org.springframework.stereotype.Repository

@Repository
interface ProductRepository {

    fun deleteAll()

    fun save(product: Product)

}
