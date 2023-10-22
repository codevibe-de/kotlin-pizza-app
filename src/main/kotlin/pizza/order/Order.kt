package pizza.order

import pizza.customer.Customer
import java.time.LocalDateTime

class Order {

    public var id: Long? = null
        private set

    public var customer: Customer? = null

    public var totalPrice: Double? = null

    public var estimatedTimeOfDelivery: LocalDateTime? = null

    //
    // --- constructors ---
    //
    constructor()

    constructor(customer: Customer?, totalPrice: Double?, estimatedTimeOfDelivery: LocalDateTime?) {
        this.customer = customer
        this.totalPrice = totalPrice
        this.estimatedTimeOfDelivery = estimatedTimeOfDelivery
    }

    constructor(
        id: Long?,
        customer: Customer?,
        totalPrice: Double?,
        estimatedTimeOfDelivery: LocalDateTime?
    ) {
        this.id = id
        this.customer = customer
        this.totalPrice = totalPrice
        this.estimatedTimeOfDelivery = estimatedTimeOfDelivery
    }

    //
    // --- other methods ---
    //

    override fun toString(): String {
        return "Order{" +
                "id=" + id +
                ", customer=" + customer +
                ", totalPrice=" + totalPrice +
                ", estimatedTimeOfDelivery=" + estimatedTimeOfDelivery +
                '}'
    }
}
