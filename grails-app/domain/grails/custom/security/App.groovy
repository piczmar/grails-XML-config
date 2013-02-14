package grails.custom.security

class App {

    static constraints = {
    }
    String description
    String apiKey
    String secret
    String callbackUrl

    String name
    String slug
    String organization
    String website
}
