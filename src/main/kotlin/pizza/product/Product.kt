package pizza.product

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Product(
    @Id var productId: String? = null,
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
