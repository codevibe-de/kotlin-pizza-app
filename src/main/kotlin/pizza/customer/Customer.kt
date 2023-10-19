package pizza.customer

class Customer {
    //
    // --- fields ---
    //

    var id: Long? = null
        private set

    var fullName: String? = null

    var address: Address? = null

    var phoneNumber: String? = null

    var orderCount = 0
        private set

    //
    // --- constructors ---
    //

    constructor(fullName: String?, address: Address?, phoneNumber: String?) {
        this.fullName = fullName
        this.address = address
        this.phoneNumber = phoneNumber
    }

    constructor(id: Long?, fullName: String?, address: Address?, phoneNumber: String?) {
        this.id = id
        this.fullName = fullName
        this.address = address
        this.phoneNumber = phoneNumber
    }

    fun setId(id: Long) {
        check(this.id == null) { "Cannot change existing id" }
        this.id = id
    }

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

