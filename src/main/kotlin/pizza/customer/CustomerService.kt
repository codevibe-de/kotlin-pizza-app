package pizza.customer

import org.springframework.stereotype.Service
import pizza.product.Product
import pizza.product.ProductNotFoundException

@Service
class CustomerService {

    fun createCustomer(customer: Customer) {
        // todo
    }

    /**
     * Returns a [Customer] with a matching phone-number or throws [CustomerNotFoundException]
     * @throws CustomerNotFoundException
     */
    fun getCustomerByPhoneNumber(phoneNumber: String): Customer {
        TODO()
    }

}