package wood.mike.duplicateFormSubmission

class DupFormController {

    def index() {
        def dupToken = params.forceInvalid ? 'abc' : null
        if( params.signIn ) {
            withForm {
                log.info( 'All good' )
            }.invalidToken {
                log.error( 'Invalid token' )
                flash.badToken = message(code: 'bad.token', default: 'Bad token')
            }
        }
        [dupToken: dupToken]
    }
}
