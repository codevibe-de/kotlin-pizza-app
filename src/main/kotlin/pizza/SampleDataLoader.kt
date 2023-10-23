package pizza

import org.springframework.stereotype.Component
import pizza.customer.Address
import pizza.customer.Customer
import pizza.customer.CustomerService
import pizza.product.Product
import pizza.product.ProductService

interface SampleDataLoader : Runnable {

    @Component("noop")
    class NoOpDataLoader : SampleDataLoader {
        override fun run() {}
    }


    @Component("small")
    class SmallDataLoader(
        private val productService: ProductService,
        private val customerService: CustomerService
    ) : SampleDataLoader {

        override fun run() {
            println("Loading sample data...")
            createProduct("S-01", "Thunfisch Salat", 6.90)
            createProduct("S-02", "Salat Italiano", 7.90)
            createProduct("S-03", "Romana Salat", 8.90)
            createProduct("P-10", "Pizza Margarita", 5.50)
            createProduct("P-11", "Pizza Capricciosa", 7.50)
            createProduct("P-12", "Pizza Spinat und Feta", 7.00)
            val address1 = createAddress("Wasserstr. 123", "40302", "Atlantis")
            createCustomer("Enrico Pallazzo", "+49 123 456789", address1)
        }

        protected fun createProduct(productId: String?, name: String?, price: Double) {
            productService.createProduct(Product(productId, name, price))
        }

        protected fun createAddress(street: String?, postalCode: String?, city: String?): Address {
            return Address(street, postalCode, city)
        }

        protected fun createCustomer(fullName: String, phoneNumber: String?, address: Address?) {
            customerService.createCustomer(
                Customer(
                    fullName,
                    address,
                    phoneNumber
                )
            )
        }
    }

}