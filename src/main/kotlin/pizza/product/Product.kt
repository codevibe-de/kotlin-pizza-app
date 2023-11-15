package pizza.product

// you need the following JPA annotations here:
// - @Entity
// - @Id
class Product(
    var productId: String? = null,
    var name: String = "no-name",
    var price: Double = 0.00,
) {

    //
    // --- other methods ---
    //

    override fun toString(): String {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}'
    }
}
