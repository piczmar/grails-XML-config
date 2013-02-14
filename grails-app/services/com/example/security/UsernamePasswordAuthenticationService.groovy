package com.example.security

import grails.custom.security.User
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority

import javax.naming.AuthenticationException

class UsernamePasswordAuthenticationService implements AuthenticationProvider {


    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;


        User.withTransaction {
            def user = User.findByUsernameAndPassword(token.getName(), (String) token.getCredentials())
            if(!user) throw new org.springframework.security.core.userdetails.UsernameNotFoundException(token.getName());
            println "user=${user.username} / ${user.password}"
            return authenticatedToken(user, authentication);
        }
//        try {
//            Account account = accountRepository.authenticate(token.getName(), (String) token.getCredentials());
//            return authenticatedToken(account, authentication);
//        } catch (SignInNotFoundException e) {
//            throw new org.springframework.security.core.userdetails.UsernameNotFoundException(token.getName(), e);
//        } catch (InvalidPasswordException e) {
//            throw new BadCredentialsException("Invalid password", e);
//        }
    }

    public boolean supports(Class<? extends Object> authentication) {
        return UsernamePasswordAuthenticationToken.class.equals(authentication);
    }

    // internal helpers

    private Authentication authenticatedToken(User account, Authentication original) {
        List<GrantedAuthority> authorities = null;
        UsernamePasswordAuthenticationToken authenticated = new UsernamePasswordAuthenticationToken(account, null, authorities);
        authenticated.setDetails(original.getDetails());
        return authenticated;
    }
}