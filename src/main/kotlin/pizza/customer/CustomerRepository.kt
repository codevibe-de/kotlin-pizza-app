package pizza.customer

interface CustomerRepository {

    fun save(customer: Customer): Customer

    fun findById(id: Long): Customer?

}