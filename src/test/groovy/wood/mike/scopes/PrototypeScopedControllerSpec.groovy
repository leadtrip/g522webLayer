package wood.mike.scopes

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class PrototypeScopedControllerSpec extends Specification implements ControllerUnitTest<PrototypeScopedController> {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
            true == false
    }
}
