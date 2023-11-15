package pizza.order

data class OrderRequest(
    val phoneNumber: String,
    val itemQuantities: Map<String, Int>
)
