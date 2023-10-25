package pizza.customer

import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface CustomerRepository : JpaRepository<Customer, Long> {

    fun findByPhoneNumber(phoneNumber: String): Optional<Customer>

    fun deleteAll()

}