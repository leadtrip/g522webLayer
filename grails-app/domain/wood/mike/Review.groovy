package wood.mike

class Review {

    Integer stars
    String article

    static belongsTo = [Book]

    static constraints = {
        stars min: 0, max: 10, nullable: false
        article nullable: false, blank: false
    }
}
