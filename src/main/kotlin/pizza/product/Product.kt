package pizza.product

class Product {

    var productId: String? = null
        private set

    var name: String? = null
        private set

    var price: Double? = null
        private set

    constructor()

    constructor(productId: String?, name: String?, price: Double?) {
        this.productId = productId
        this.name = name
        this.price = price
    }

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
