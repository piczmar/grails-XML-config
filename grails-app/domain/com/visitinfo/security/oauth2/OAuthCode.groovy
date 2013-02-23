package com.visitinfo.security.oauth2

class OAuthCode {

    static constraints = {
        authentication(maxSize:  1000000000)
    }
    static mapping = {
        table(name: 'oauth_code')
        version false
    }
    String authentication

}
/*

create table oauth_code (
  code VARCHAR(256), authentication LONGVARBINARY
);
 */
