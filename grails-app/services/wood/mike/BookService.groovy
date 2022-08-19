package wood.mike

import grails.gorm.transactions.Transactional
import grails.validation.ValidationException

@Transactional
class BookService {

    Book get(Serializable id) {
        Book.get(id)
    }

    List<Book> list(Map args) {
        Book.findAll(args)
    }

    Long count() {
        Book.count
    }

    void delete(Serializable id){
        Book.findById(id)?.delete()
    }

    Book save(Book book) {
        if (!book.save()) {
            throw new ValidationException("Validation failed", book.errors)
        }
    }

    Book changeTitle(Serializable id, String title) {
        Book book = Book.get(id)
        book.title = title
        book
    }
}