package pizza.customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {

    fun findByPhoneNumber(phoneNumber: String): Optional<Customer>

}