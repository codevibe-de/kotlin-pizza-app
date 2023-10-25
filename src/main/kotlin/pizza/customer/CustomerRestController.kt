package pizza.customer

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class CustomerRestController(
    private val customerService: CustomerService
) {
    companion object {
        const val ROOT_PATH = "/customers"
        const val CREATE_ENDPOINT: String = ROOT_PATH
        const val GET_ONE_ENDPOINT: String = "$ROOT_PATH/{customerId}"
    }

    @GetMapping(GET_ONE_ENDPOINT)
    fun getCustomer(@PathVariable customerId: Long): Customer =
        customerService.getCustomer(customerId)


    @PostMapping(CREATE_ENDPOINT)
    @ResponseStatus(HttpStatus.CREATED)
    fun createCustomer(@RequestBody customer: Customer): Customer =
        customerService.createCustomer(customer)

}