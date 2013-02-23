package com.example.security

import com.visitinfo.security.User
import org.springframework.dao.DataAccessException
import org.springframework.security.core.authority.GrantedAuthorityImpl
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

import javax.sql.DataSource
import com.visitinfo.security.VisitInfoUserDetails

class VisitInfoUserDetailsService implements UserDetailsService {

    def DataSource dataSource
    static final List NO_ROLES = [new GrantedAuthorityImpl("ROLE_NO_ROLES")]


    @Override
    UserDetails loadUserByUsername(String username)  throws UsernameNotFoundException, DataAccessException {

        User.withTransaction {
            def user = User.findByUsername(username)
            if(!user) throw new UsernameNotFoundException('Unable to find Person by username', username)
            println "user=${user.username} / ${user.password}"
            return buildUserFromUserEntity(user)
        }


    }

    VisitInfoUserDetails buildUserFromUserEntity(User user) {
        try {
            println "building grailsuser..."
            def authorities = user.authorities.collect { new GrantedAuthorityImpl(it.authority) }
            println "size = ${authorities.size()}"
            authorities.each {
                println it
            }

            def userDetails = new VisitInfoUserDetails(user.username, user.password, user.enabled,
                    !user.accountExpired, !user.passwordExpired,
                    !user.accountLocked, authorities ?: NO_ROLES, user.id)
            println("USER DETAILS ${userDetails}")
            return userDetails
        } catch (Throwable thr) {
            println "error: ${thr.getMessage()}"
            thr.printStackTrace(System.err);

        }
        return null
    }

}

