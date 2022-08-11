package wood.mike.rendering

import groovy.xml.MarkupBuilder

class HtmlMarkupController {

    def index() {
        def writer = new StringWriter()
        def builder = new MarkupBuilder(writer)
        builder.html {
            head {
                title 'Rendering with markup builder'
            }
            body {
                h1 'Hello'
                a(href: '/bookDefaultAction') {
                    mkp.yield 'Books'
                }
            }
        }

        def html = writer.toString()
        render html
    }
}
