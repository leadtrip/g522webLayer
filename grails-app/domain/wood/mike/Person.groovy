package wood.mike

import java.time.LocalDate

class Person {
    String forename
    String surname
    LocalDate dateOfBirth
    Address homeAddress

    static constraints = {
        forename nullable: false, blank: false
        surname nullable: false, blank: false
        dateOfBirth nullable: false
        homeAddress nullable: false
    }
}
