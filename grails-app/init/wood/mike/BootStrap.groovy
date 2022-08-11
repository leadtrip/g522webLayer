package wood.mike

import grails.gorm.transactions.Transactional

class BootStrap {

    def init = { servletContext ->
        addBooks()
    }

    @Transactional
    def addBooks() {
        new Book(title: 'chickens', author: 'bob').save()
        new Book(title: 'lamps', author: 'greg').save()
        new Book(title: 'lighthouse', author: 'arthur').save()
        new Book(title: 'sewage', author: 'chris').save()
        new Book(title: 'barbs', author: 'clint').save()
    }

    def destroy = {
    }
}
