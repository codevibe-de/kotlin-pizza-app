package pizza.customer

import java.util.Optional

interface CustomerRepository {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Optional<Customer>

    fun deleteAll()

}