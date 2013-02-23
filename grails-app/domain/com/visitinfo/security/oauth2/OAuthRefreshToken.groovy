package com.visitinfo.security.oauth2

class OAuthRefreshToken {

    static constraints = {
        token(maxSize:  1000000000)
        authentication(maxSize:  1000000000)
    }
    static mapping = {
        table(name: 'oauth_refresh_token')
        id column: 'token_id', generator:'assigned',type:'string', sqlType: "varchar2(256 char)"
        version false
    }
    String token
    String authentication

}
/*
create table oauth_refresh_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication LONGVARBINARY
);
 */
