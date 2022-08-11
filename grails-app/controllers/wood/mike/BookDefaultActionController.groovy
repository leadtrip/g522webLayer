package wood.mike

import grails.gorm.transactions.ReadOnly

class BookDefaultActionController {

    static defaultAction = "randomBook"

    def index() { }

    @ReadOnly
    def randomBook() {
        render Book.get(1+Random.newInstance().nextInt(Book.count))
    }
}
