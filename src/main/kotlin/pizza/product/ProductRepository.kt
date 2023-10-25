package pizza.product

interface ProductRepository {

    fun deleteAll()

    fun save(product: Product)

}
