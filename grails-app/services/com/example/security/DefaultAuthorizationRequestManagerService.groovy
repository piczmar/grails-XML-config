package com.example.security

import org.springframework.security.oauth2.common.exceptions.InvalidClientException
import org.springframework.security.oauth2.common.exceptions.InvalidScopeException
import org.springframework.security.oauth2.common.util.OAuth2Utils
import org.springframework.security.oauth2.provider.AuthorizationRequest
import org.springframework.security.oauth2.provider.ClientDetails
import org.springframework.security.oauth2.provider.DefaultAuthorizationRequest

class DefaultAuthorizationRequestManagerService {

    private final ClientDetailsService clientDetailsService;

    public DefaultAuthorizationRequestManagerService(ClientDetailsService clientDetailsService) {
        this.clientDetailsService = clientDetailsService;
    }

    public AuthorizationRequest createAuthorizationRequest(Map<String, String> parameters) {

        String clientId = parameters.get("client_id");
        if (clientId == null) {
            throw new InvalidClientException("A client id must be provided");
        }
        ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
        Set<String> scopes = OAuth2Utils.parseParameterList(parameters.get("scope"));
        if ((scopes == null || scopes.isEmpty())) {
            // If no scopes are specified in the incoming data, use the default values registered with the client
            // (the spec allows us to choose between this option and rejecting the request completely, so we'll take the
            // least obnoxious choice as a default).
            scopes = clientDetails.getScope();
        }
        DefaultAuthorizationRequest request = new DefaultAuthorizationRequest(parameters, Collections.<String, String> emptyMap(),
                clientId, scopes);
        request.addClientDetails(clientDetails);
        return request;

    }

    public void validateParameters(Map<String, String> parameters, ClientDetails clientDetails) {
        if (parameters.containsKey("scope")) {
            if (clientDetails.isScoped()) {
                Set<String> validScope = clientDetails.getScope();
                for (String scope : OAuth2Utils.parseParameterList(parameters.get("scope"))) {
                    if (!validScope.contains(scope)) {
                        throw new InvalidScopeException("Invalid scope: " + scope, validScope);
                    }
                }
            }
        }
    }
}
