package com.example.security

import org.apache.log4j.Logger
import org.springframework.security.oauth2.common.OAuth2AccessToken

class TokenService extends org.springframework.security.oauth2.provider.token.DefaultTokenServices {

    private static Logger logger = Logger.getLogger(TokenService.class);

    public org.springframework.security.oauth2.common.OAuth2AccessToken createAccessToken(org.springframework.security.oauth2.provider.OAuth2Authentication authentication) throws org.springframework.security.core.AuthenticationException {
        OAuth2AccessToken token = super.createAccessToken(authentication);
        logger.debug(".. created token.. " + token);
        return token;
    }

    public org.springframework.security.oauth2.common.OAuth2AccessToken getAccessToken(org.springframework.security.oauth2.provider.OAuth2Authentication authentication) {
        logger.debug(".. get access  token.. " + authentication);
        return super.getAccessToken(authentication);
    }


    public void setTokenStore(org.springframework.security.oauth2.provider.token.TokenStore tokenStore) {
        logger.debug(".. tokenStore.. " + tokenStore);
        super.setTokenStore(tokenStore);
    }

    public void setClientDetailsService(org.springframework.security.oauth2.provider.ClientDetailsService clientDetailsService) {

        logger.debug(".. clientDetailsService.. " + clientDetailsService);
        super.setClientDetailsService(clientDetailsService);
    }

}
