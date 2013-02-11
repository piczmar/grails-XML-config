import grails.custom.security.Role
import grails.custom.security.User
import grails.custom.security.UserRole

class BootStrap {

    def init = { servletContext ->

        User user = new User(username: 'admin', password: 'admin', enabled: true)
        user.save(flush: true)
        Role role = new Role(authority: "ROLE_USER")
        role.save(flush: true)
        UserRole.create user, role, true
    }
    def destroy = {
    }
}
