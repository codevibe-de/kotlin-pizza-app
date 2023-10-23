package pizza.product

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class Product(
    @Id var productId: String? = null,
    var name: String? = null,
    var price: Double? = null,
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
