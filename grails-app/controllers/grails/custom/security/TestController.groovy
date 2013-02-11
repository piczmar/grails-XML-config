package grails.custom.security

import org.springframework.security.access.annotation.Secured

class TestController {

    @Secured("ROLE_USER")
    def index() {
        render "Damn, it really works!!"
    }

}
