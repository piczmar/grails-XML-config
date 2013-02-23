package members

import grails.converters.JSON
import com.visitinfo.security.User

class MembersController {

       def profile(User account) {

        def out = [accountId:1,displayName:"Keith Donald",pictureUrl:"http://localhost:8080/greenhouse/resources/profile-pics/male/large.jpg"]
        //def user = User.findById(account.getId())
        render text: out as JSON, contentType: 'application/json', status:200
    }


}
