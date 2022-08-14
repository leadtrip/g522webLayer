package wood.mike

import grails.testing.gorm.DomainUnitTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import wood.mike.dataBinding.PersonController

import java.time.LocalDate
import java.time.Month

class PersonControllerSpec extends Specification implements ControllerUnitTest<PersonController>, DomainUnitTest<Person> {

    def populateValidParams(params) {
        assert params != null

        params['forename'] = 'Clive'
        params['surname'] = 'Barker'
        params['dateOfBirth'] = LocalDate.of(1942, Month.JANUARY, 2)
        params['homeAddress.addressLine1'] = '18 stick lane'
        params['homeAddress.addressLine3'] = 'Wendleford'
        params['homeAddress.addressLine4'] = 'Bogbrushington'
        params['homeAddress.addressLine5'] = 'BB1 9ZZ'
    }

    void setup() {
        controller.personService = getDatastore().getService(PersonService)
    }

    def "test save"() {
        given:
            populateValidParams(params)
        and:
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
        when:
            controller.save()   // NOT BUILDING A Person DOMAIN IN THE TEST, GRAILS WILL DO THIS EN ROUTE TO THE CONTROLLER ACTION
        then:
            def people = Person.all
            people.size() == 1
            def person1 = people[0]
            person1.forename == 'Clive'
            person1.homeAddress.addressLine1 == '18 stick lane'
    }
}






