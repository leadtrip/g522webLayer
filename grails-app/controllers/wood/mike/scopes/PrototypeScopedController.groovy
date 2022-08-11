package wood.mike.scopes

class PrototypeScopedController {

    static scope = 'prototype'

    int tally

    def index() {
        render "This controller has been loaded ${++tally} time"
    }
}
