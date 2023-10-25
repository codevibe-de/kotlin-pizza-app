package pizza.order

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import pizza.customer.Customer
import java.time.LocalDateTime

@Entity
@Table(name = "orders")
class Order {

    @Id
    @GeneratedValue
    var id: Long? = null

    @ManyToOne
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
