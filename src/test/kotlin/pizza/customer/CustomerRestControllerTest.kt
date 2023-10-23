package pizza.customer

import com.fasterxml.jackson.databind.ObjectMapper
import com.jayway.jsonpath.JsonPath
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath


@SpringBootTest
@AutoConfigureMockMvc
internal class CustomerRestControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var customerRepository: CustomerRepository

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    private val customerFullName = "Bill Gates"
    private val customerAddress: Address = Address("1415 L Street, Suite 200", "95814", "Sacramento, CA")
    private val customerPhoneNumber = "+1 222 3333333"

    /**
     * Validates a customer GET response using JSONAssert
     */
    @Test
    fun getCustomer_variant1() {
        // given
        var customer = Customer(customerFullName, customerAddress, customerPhoneNumber)
        customer = customerRepository.save(customer)

        // when
        val actualJson = mockMvc
            .perform(get(CustomerRestController.GET_ONE_ENDPOINT, customer.id))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn().response.contentAsString

        // then
        val expectedJson = toJson(customer)
        JSONAssert.assertEquals(expectedJson, actualJson, false)
    }


    /**
     * Validates a customer GET response using JsonPath
     */
    @Test
    fun getCustomer_variant2() {
        // given
        var customer = Customer(customerFullName, customerAddress, customerPhoneNumber)
        customer = customerRepository.save(customer)

        // when
        val resultActions = mockMvc
            .perform(get(CustomerRestController.GET_ONE_ENDPOINT, customer.id))
            .andExpect(MockMvcResultMatchers.status().isOk())

        // then
        resultActions
            .andExpect(jsonPath("$.fullName", Matchers.`is`<String>(customerFullName)))
            .andExpect(jsonPath("$.address.city", Matchers.`is`(customerAddress.city)))
    }


    @Test
    fun createCustomer() {
        // when
        val customerName = "Test Customer"
        val json = """{"fullName":"$customerName"}"""
        val resultActions = mockMvc
            .perform(
                post(CustomerRestController.CREATE_ENDPOINT)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(json)
            )

        // then - assert response
        resultActions
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andExpect(jsonPath("$.orderCount", Matchers.`is`(0)))
            .andExpect(jsonPath("$.id").isNumber())

        // then - assert persistence
        val responseJson = resultActions.andReturn().response.contentAsString
        val customerId = JsonPath.read<Int>(responseJson, "$.id")
        val optionalCustomer = customerRepository.findById(customerId.toLong())
        assertThat(optionalCustomer).isNotEmpty
        val customer = optionalCustomer.get()
        assertThat(customer.fullName).isEqualTo(customerName)
    }


    @Throws(com.fasterxml.jackson.core.JsonProcessingException::class)
    private fun toJson(obj: Any): String {
        return objectMapper.writeValueAsString(obj)
    }
}