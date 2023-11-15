package pizza.customer

// you need the following JPA annotations here:
// - @Entity
// - @Id
// - @GeneratedValue
// - @Embedded
class Customer {

    var id: Long? = null
        set(value) {
            check(this.id == null) { "Cannot change existing id" }
            field = value
        }

    var fullName: String

    var address: Address?

    var phoneNumber: String?

    var orderCount: Int = 0


    //
    // --- constructors ---
    //

    constructor() : this("", null, null)

    constructor(fullName: String, address: Address?, phoneNumber: String?) {
        this.id = null
        this.fullName = fullName
        this.address = address
        this.phoneNumber = phoneNumber
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

