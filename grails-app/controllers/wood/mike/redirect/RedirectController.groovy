package wood.mike.redirect

import grails.web.Action
import wood.mike.Book

class RedirectController {

    def index() {
        def methods =
            getClass().methods.toList()
                .stream()
                .filter(m -> m.getAnnotation(Action) != null)
                .map(m-> m.name)

        [actions: methods, params: params]
    }

    def toIndex() {
        redirect action: 'index'
    }

    def toHome() {
        redirect uri: '/'
    }

    def toBook() {
        redirect Book.findByTitle('sewage')
    }

    def redirectCurrentParams() {
        redirect action: 'index', params: params
    }

    def redirectNewParams() {
        redirect action: 'index', params: [sauce: 'ketchup']
    }
}
