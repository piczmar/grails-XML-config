package com.example.security

import com.visitinfo.security.User
import org.springframework.dao.DuplicateKeyException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.social.showcase.account.UsernameAlreadyInUseException
import org.springframework.transaction.annotation.Transactional
import org.springframework.social.showcase.account.AccountService

class UserAccountService implements AccountService{

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void createAccount(User user) throws UsernameAlreadyInUseException {
        try {

            User u = User.findByUsername(user.username)
            if(u){
                throw new UsernameAlreadyInUseException()
            }
            user.save(flush: true, validate: true)
            if(user.hasErrors()){
                println("Cannot save user because of errors")
                throw new UsernameAlreadyInUseException()
            }
        } catch (DuplicateKeyException e) {
            throw new UsernameAlreadyInUseException(user.getUsername());
        }
    }

    public User findAccountByUsername(String username) {
        return   User.findByUsername(username)
    }
}
