package pizza.customer

class Customer(
    idParam: Long? = null,
    var fullName: String? = null,
    var address: Address? = null,
    var phoneNumber: String? = null,
    var orderCount: Int = 0,
) {

    var id: Long? = idParam
        set(value) {
            check(this.id == null) { "Cannot change existing id" }
            field = value
        }

    constructor(fullName: String?, address: Address?, phoneNumber: String?) :
            this(null, fullName, address, phoneNumber)

    //
    // --- other methods ---
    //

    fun increaseOrderCount(): Int {
        return orderCount++
    }

    override fun toString(): String {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", address=" + address +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orderCount=" + orderCount +
                '}'
    }
}

