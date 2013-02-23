package com.visitinfo.security.oauth2

class OAuthClientToken {

    static constraints = {
        token(maxSize:  1000000000)
        authenticationId(maxSize:256)
        userName(maxSize:256)
        clientId(maxSize: 256)
    }
    static mapping = {
        table(name: 'oauth_client_token')
        id column: 'token_id', generator:'assigned',type:'string', sqlType: "varchar2(256 char)"
        version false
    }
    String token
    String authenticationId
    String userName
    String clientId

}
/*

create table oauth_client_token (
  token_id VARCHAR(256),
  token LONGVARBINARY,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

*/