package pizza.customer

class Address(
    var street: String? = null,
    var postalCode: String? = null,
    var city: String? = null,
) {

    //
    // --- other methods ---
    //

    override fun toString(): String {
        return "Address{" +
                "street='" + street + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}'
    }

}

