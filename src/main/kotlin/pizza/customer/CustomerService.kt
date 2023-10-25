package pizza.customer

import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) {

    fun createCustomer(customer: Customer) =
        customerRepository.save(customer)


    fun getCustomer(id: Long): Customer =
        customerRepository.findById(id)
            .orElseThrow { CustomerNotFoundException("for id $id") }


    /**
     * Returns a [Customer] with a matching phone-number or throws [CustomerNotFoundException]
     * @throws CustomerNotFoundException
     */
    fun getCustomerByPhoneNumber(phoneNumber: String): Customer =
        customerRepository.findByPhoneNumber(phoneNumber)
            .orElseThrow { CustomerNotFoundException("for phone-number $phoneNumber") }

}