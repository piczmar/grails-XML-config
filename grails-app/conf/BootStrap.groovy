import grails.custom.security.*
import com.visitinfo.security.App
import com.visitinfo.security.AppDeveloper
import com.visitinfo.security.Role
import com.visitinfo.security.User
import com.visitinfo.security.UserRole

class BootStrap {

    def init = { servletContext ->

        User user = new User(username: 'admin', password: 'admin', enabled: true)
        user = user.save(flush: true)
        Role role = new Role(authority: "ROLE_ADMIN")
        role.save(flush: true)
        UserRole.create user, role, true

        user = new User(username: 'user', password: 'user', enabled: true)
        user = user.save(flush: true)
        role = new Role(authority: "ROLE_USER")
        role.save(flush: true)
        UserRole.create user, role, true

        App app = new App(name: 'VisitInfo for Android',
                slug: 'greenhouse-for-android',
                description: 'Our slick mobile client for the Google Android',
                organization: 'SpringSource',
                website: 'http://www.springsource.com',
                apiKey: 'e9fbccdae98d5696', secret: '9fa283e1eca2d4e8', callbackUrl: 'x-com-springsource-greenhouse://oauth-response')
        app = app.save(flush: true)

        AppDeveloper developer = new AppDeveloper(application: app, user: user)
        developer.save(flush: true)
        assert App.findByApiKey('e9fbccdae98d5696') != null
    }
    def destroy = {
    }
}
