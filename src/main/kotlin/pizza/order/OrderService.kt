package pizza.order

import org.springframework.stereotype.Service
import pizza.customer.CustomerService
import pizza.product.ProductService

@Service
class OrderService(
    private val orderRepository: OrderRepository,
    private val customerService: CustomerService,
    private val productService: ProductService,
) {

    fun placeOrder(phoneNumber: String, itemQuantities: Map<String, Int>): Order {
        // load customer
        val customer = customerService.getCustomerByPhoneNumber(phoneNumber)

        // ask product-service for total price
        val totalPrice = productService.getTotalPrice(itemQuantities)

        // create order
        val order = Order(
            customer = customer,
            totalPrice = totalPrice,
            estimatedTimeOfDelivery = null
        )

        // persist and return it
        return orderRepository.save(order)
    }


    fun getOrders(): List<Order> =
        orderRepository.findAll()

}
