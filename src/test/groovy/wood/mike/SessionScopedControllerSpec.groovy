package wood.mike

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import wood.mike.scopes.SessionScopedController

class SessionScopedControllerSpec extends Specification implements ControllerUnitTest<SessionScopedController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
