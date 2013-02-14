package members

import com.springsource.greenhouse.members.ProfileRepository
import grails.converters.JSON
import grails.custom.security.User

class MembersController {

    ProfileRepository profileRepository;
    //def springSecurityService = org.codehaus.groovy.grails.commons.ApplicationHolder.application.mainContext.getBean("springSecurityService")
    def profile(User account) {

        def out = [accountId:1,displayName:"Keith Donald",pictureUrl:"http://localhost:8080/greenhouse/resources/profile-pics/male/large.jpg"]
        def user = profileRepository.findByAccountId(account.getId())
        render text: out as JSON, contentType: 'application/json', status:200
    }


}
