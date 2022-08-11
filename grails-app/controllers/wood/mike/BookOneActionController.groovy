package wood.mike

class BookOneActionController {

    def books() {
        render layout: 'main', text: 'I am the only action so I am the default'
    }
}
