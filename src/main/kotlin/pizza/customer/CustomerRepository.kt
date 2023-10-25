package pizza.customer

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CustomerRepository : JpaRepository<Customer, Long> {

    // we stick to using Optional here (as all inherited find-functions do...)
    fun findByPhoneNumber(phoneNumber: String): Optional<Customer>

}