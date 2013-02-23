package org.springframework.social.showcase.account

import com.visitinfo.security.User

public interface AccountService {


    public void createAccount(User user) throws UsernameAlreadyInUseException;

    public User findAccountByUsername(String username) ;
}
