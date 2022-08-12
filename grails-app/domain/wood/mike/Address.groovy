package wood.mike

class Address {
    String addressLine1
    String addressLine2
    String addressLine3
    String addressLine4

    static constraints = {
        addressLine1 nullable: false, blank: false
        addressLine2 nullable: true, blank: false
        addressLine3 nullable: true, blank: false
        addressLine4 nullable: true, blank: false
    }
}
