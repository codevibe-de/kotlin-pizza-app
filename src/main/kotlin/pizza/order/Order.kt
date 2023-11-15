package pizza.order

import pizza.customer.Customer
import java.time.LocalDateTime

// you need the following JPA annotations here:
// - @Entity
// - @Table
// - @Id
// - @GeneratedValue
// - @ManyToOne
class Order {

    var id: Long? = null

    var customer: Customer? = null

    var totalPrice: Double? = null

    var estimatedTimeOfDelivery: LocalDateTime? = null

    //
    // --- constructors ---
    //

    constructor()

    constructor(customer: Customer?, totalPrice: Double?, estimatedTimeOfDelivery: LocalDateTime?) {
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
