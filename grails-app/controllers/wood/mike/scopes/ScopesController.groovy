package wood.mike.scopes

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

class ScopesController {

    final static APPLICATION_SCOPE_KEY = 'applicationScopeKey'
    final static SESSION_SCOPE_KEY = 'sessionScopeKey'
    final static REQUEST_SCOPE_KEY = 'requestScopeKey'
    final static PARAMS_SCOPE_KEY = 'paramsScopeKey'

    def index() {}

    def addAndGetFromApplicationScope() {
        def currentValue = servletContext.getAttribute( APPLICATION_SCOPE_KEY )
        if( !currentValue ) {
            servletContext.setAttribute(APPLICATION_SCOPE_KEY, buildValue('application'))
            currentValue = servletContext.getAttribute( APPLICATION_SCOPE_KEY )
        }
        redirect action: 'index', params: [result: currentValue]
    }

    def addAndGetFromSessionScope() {
        def currentValue = session[SESSION_SCOPE_KEY]
        if(!currentValue) {
            session[SESSION_SCOPE_KEY] = buildValue('session')
            currentValue = session[SESSION_SCOPE_KEY]
        }
        redirect action: 'index', params: [result: currentValue]
    }

    def addAndGetFromRequestScope() {
        def currentValue = request[REQUEST_SCOPE_KEY]
        if(!currentValue) {
            request[REQUEST_SCOPE_KEY] = buildValue('request')
            currentValue = request[REQUEST_SCOPE_KEY]
        }
        redirect action: 'index', params: [result: currentValue]
    }

    def addAndGetFromParamsScope() {
        def currentValue = params[PARAMS_SCOPE_KEY]
        if( !currentValue ) {
            params[PARAMS_SCOPE_KEY] = buildValue('params')
            currentValue = params[PARAMS_SCOPE_KEY]
        }
        redirect action: 'index', params: [result: currentValue]
    }

    def buildValue(scope) {
        "$scope ${DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format( LocalDateTime.now() )}"
    }

    def getFromApplicationScope() {
        redirect( action: 'index', params:[result: servletContext.getAttribute(APPLICATION_SCOPE_KEY)])
    }

    def getFromSessionScope() {
        redirect( action: 'index', params:[result: session[SESSION_SCOPE_KEY]])
    }

    def getFromRequestScope() {
        redirect( action: 'index', params:[result: request[REQUEST_SCOPE_KEY]])
    }

    def getFromParamsScope() {
        redirect( action: 'index', params:[result: params[PARAMS_SCOPE_KEY]])
    }
}
