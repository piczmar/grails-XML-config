package com.visitinfo.security.oauth2

class OAuthAccessToken {

    static constraints = {
        token(maxSize:  1000000000)
        authenticationId(maxSize:256)
        userName(maxSize:256)
        clientId(maxSize: 256)
        authentication(maxSize:  1000000000)
        refreshToken(maxSize: 256)
    }
    static mapping = {
        table(name: 'oauth_access_token')
        id column: 'token_id', generator:'assigned',type:'string', sqlType: "varchar2(256 char)"
        version false
    }
    String token
    String authenticationId
    String userName
    String clientId
    String authentication
    String refreshToken


}
//create table oauth_access_token (
//        token_id VARCHAR(256),
//        token LONGVARBINARY,
//        authentication_id VARCHAR(256),
//        user_name VARCHAR(256),
//        client_id VARCHAR(256),
//        authentication LONGVARBINARY,
//        refresh_token VARCHAR(256)
//);