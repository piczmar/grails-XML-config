package com.example.security

import grails.custom.security.App
import org.apache.log4j.Logger
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception
import org.springframework.security.oauth2.provider.BaseClientDetails
import org.springframework.security.oauth2.provider.ClientDetails

class ClientDetailsService implements org.springframework.security.oauth2.provider.ClientDetailsService {

    private static Logger logger = Logger.getLogger(ClientDetailsService.class)

    @Override
    public ClientDetails loadClientByClientId(String appId) throws OAuth2Exception {
        try {
            logger.debug('.. search APP for id: ' + appId);
            return clientDetailsFor(App.findByApiKey(appId));
        } catch (Exception e) {
            throw new OAuth2Exception("Invalid OAuth App ID " + appId, e);
        }
    }

    private ClientDetails clientDetailsFor(App app) {
        return new AppClientDetails(app);
    }

    @SuppressWarnings("serial")
    private static class AppClientDetails extends BaseClientDetails {

        public AppClientDetails(App app) {
            // TODO Consider putting hard-coded values in DB instead.
            super(app.getApiKey(), "greenhouseApi", "read,write", "authorization_code,token,password", "ROLE_CLIENT", app.getCallbackUrl());
            logger.debug("found APP " + app);
            setClientSecret(app.getSecret());
        }

    }
}
