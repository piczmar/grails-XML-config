import grails.custom.security.*

class BootStrap {

    def init = { servletContext ->

        User user = new User(username: 'admin', password: 'admin', enabled: true)
        user = user.save(flush: true)
        Role role = new Role(authority: "ROLE_USER")
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

/*

  insert into Member (firstName, lastName, email, password, username, gender, birthdate) values ('Keith' , 'Donald', 'keith.donald@springsource.com', 'melbourne', 'kdonald', 'M', '1977-12-29');
insert into Member (firstName, lastName, email, password, username, gender, birthdate) values ('Craig' , 'Walls', 'craig@habuma.com', 'freebird', 'habuma', 'M', '1975-3-4');
insert into Member (firstName, lastName, email, password, username, gender, birthdate) values ('Roy', 'Clarkson', 'rclarkson@vmware.com', 'atlanta', 'rclarkson', 'M', '1977-11-15');
insert into Member (firstName, lastName, email, password, username, gender, birthdate) values ('Jeremy', 'Grelle', 'jgrelle@vmware.com', 'churchkey', 'jgrelle', 'M', '1977-11-28');
insert into Member (firstName, lastName, email, password, username, gender, birthdate) values ('Mark', 'Fisher', 'mfisher@vmware.com', 'boston', 'mfisher', 'M', '1976-10-12');
insert into Member (firstName, lastName, email, password, username, gender, birthdate) values ('Keri', 'Donald', 'keridonald@gmail.com', 'donaldbarn', 'kkdonald', 'F', '1976-7-4');
insert into Member (firstName, lastName, email, password, username, gender, birthdate) values ('David', 'Winterfeldt', 'dwinterfeldt@vmware.com', 'sanfran', 'dwinterfeldt', 'M', '1973-11-4');

-- Greenhouse for iPhone Tester
insert into App (name, slug, description, organization, website, apiKey, secret, callbackUrl) values ('Greenhouse for iPhone', 'greenhouse-for-iphone', 'Our slick mobile client for the Apple iPhone ', 'SpringSource', 'http://www.springsource.com', 'a08318eb478a1ee31f69a55276f3af64', '80e7f8f7ba724aae9103f297e5fb9bdf', 'x-com-springsource-greenhouse://oauth-response');
insert into AppDeveloper (app, member) values (1, 1);
insert into AppDeveloper (app, member) values (1, 2);
insert into AppDeveloper (app, member) values (1, 3);

-- Greenhouse for Android Tester
insert into App (name, slug, description, organization, website, apiKey, secret, callbackUrl)
    values ('Greenhouse for Android', 'greenhouse-for-android', 'Our slick mobile client for the Google Android ', 'SpringSource', 'http://www.springsource.com', 'e9fbccdae98d5696', '9fa283e1eca2d4e8', 'x-com-springsource-greenhouse://oauth-response');
insert into AppDeveloper (app, member) values (2, 1);
insert into AppDeveloper (app, member) values (2, 2);
insert into AppDeveloper (app, member) values (2, 3);
*/