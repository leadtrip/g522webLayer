package wood.mike

class Book {

    String title
    String author

    static hasMany = [reviews: Review]

    static constraints = {
        title nullable: false, blank: false
        author nullable: false, blank: false
    }

    @Override
    String toString() {
        "$title by $author"
    }
}
