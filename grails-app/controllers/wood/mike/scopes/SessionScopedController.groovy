package wood.mike.scopes

class SessionScopedController {

    static scope = 'session'

    int tally

    def index() {
        render "This controller has been loaded ${++tally} times during this session"
    }
}
