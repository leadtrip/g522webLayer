package wood.mike

import grails.testing.gorm.DataTest
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification
import wood.mike.dataBinding.BookController

/**
 * Book has a hasMany relationship with Review using the default Set implementation
 */
class BookControllerSpec extends Specification implements ControllerUnitTest<BookController>, DataTest{

    void setupSpec() {
        mockDomains Book
    }

    def populateValidParams(params) {
        assert params != null

        params['book.title'] = 'Lemons'
        params['book.author'] = 'Hamish'
        params['book.reviews[0].stars'] = 1
        params['book.reviews[0].article'] = 'Shocking'
        params['book.reviews[1].stars'] = 8
        params['book.reviews[1].article'] = 'Immense'
    }

    // we want to use the real service and because this is a hand cranked service we can use a spock spy
    def bookService = Spy(BookService)

    void setup() {
        controller.bookService = bookService
    }

    void "test create book"() {
        given:
            populateValidParams(params)
        and:
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
        when:
            controller.save()   // NOT BUILDING A Book DOMAIN IN THE TEST, GRAILS WILL DO THIS EN ROUTE TO THE CONTROLLER ACTION
        then:
            def allBooks = Book.all
            allBooks.size() == 1
            def book1 = allBooks[0]
            book1.title == 'Lemons'
            book1.author == 'Hamish'
            def reviews = book1.reviews
            reviews.size() == 2
            reviews*.stars.sum() == 9
    }

}






