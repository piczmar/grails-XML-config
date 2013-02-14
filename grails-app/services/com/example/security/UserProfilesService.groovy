package com.example.security

import com.springsource.greenhouse.members.ProfileRepository
import grails.custom.security.User

class UserProfilesService implements ProfileRepository {


    @Override
    User findById(String profileId) {
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    User findByAccountId(Long accountId) {
//        User.findById(accountId)
        User.findByUsername('admin');
    }
}
