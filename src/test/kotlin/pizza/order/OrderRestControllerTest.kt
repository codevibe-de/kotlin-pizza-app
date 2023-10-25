package pizza.order

import com.fasterxml.jackson.databind.ObjectMapper
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.slot
import org.hamcrest.Matchers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.http.MediaType
import org.springframework.test.context.TestPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import pizza.customer.Customer
import pizza.customer.CustomerRepository
import pizza.customer.CustomerService
import pizza.order.OrderRestController
import pizza.product.Product
import pizza.product.ProductRepository
import pizza.product.ProductService
import java.util.*

@WebMvcTest(OrderRestController::class)
@Import(OrderService::class, CustomerService::class, ProductService::class)
@TestPropertySource(properties = ["app.skip-loading-sample-data=true"])
internal class OrderRestControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockkBean
    private lateinit var productRepository: ProductRepository

    @MockkBean
    private lateinit var customerRepository: CustomerRepository

    @MockkBean(relaxed = true)
    private lateinit var orderRepository: OrderRepository

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @BeforeEach
    fun setupTestData() {
        every { productRepository.findById("p1") } returns
                Optional.of(Product("p1", "Product One", 1.00))
        every { customerRepository.findByPhoneNumber("040-112233") } returns
                Optional.of(Customer("Toni Test", null, "040-112233"))
        val orderSlot = slot<Order>()
        every { orderRepository.save(capture(orderSlot)) } answers { orderSlot.captured }
    }

    @Test
    fun placeOrder() {
        // given
        val orderRequestData = OrderRequest(
            phoneNumber = "040-112233",
            itemQuantities = Collections.singletonMap("p1", 2)
        )

        // when
        val resultActions = mockMvc.perform(
            MockMvcRequestBuilders.post(OrderRestController.PLACE_ORDER_ENDPOINT)
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJson(orderRequestData))
        )

        // then
        resultActions
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.totalPrice", Matchers.`is`(2.0)))
            .andExpect(jsonPath("$.customer.fullName", Matchers.`is`("Toni Test")))
    }

    private fun toJson(`object`: Any): String {
        return objectMapper.writeValueAsString(`object`)
    }
}