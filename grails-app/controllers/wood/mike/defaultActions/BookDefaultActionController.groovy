package wood.mike.defaultActions

import grails.gorm.transactions.ReadOnly
import wood.mike.Book

class BookDefaultActionController {

    static defaultAction = "randomBook"

    def index() { }

    @ReadOnly
    def randomBook() {
        render Book.get(1+Random.newInstance().nextInt(Book.count))
    }
}
