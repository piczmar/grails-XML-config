package grails.xml.config

class GrailsController {
    def myBean

    def index() { }
    def test = {
        return [text: "from Grails controller",text2: myBean.text]
    }
}
