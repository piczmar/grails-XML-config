package org.springframework.security.oauth2.provider;

import org.springframework.security.oauth2.provider.endpoint.AuthorizationEndpoint;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;

import java.util.Map;

/**
 * Strategy for managing AuthorizationRequest instances during a token grant.
 *
 * @author Dave Syer
 *
 */
public interface AuthorizationRequestManager {

    /**
     * Create a new {@link AuthorizationRequest} extracting all the needed information from the incoming parameter map.
     * Typical implementations would load the client details from the client id provided and validate the grant type and
     * scopes, populating any fields in the request that are known only to the authorization server.
     *
     * @param authorizationParameters the parameters in the request
     * @return a new AuthorizationRequest
     */
    AuthorizationRequest createAuthorizationRequest(Map<String, String> authorizationParameters);

    /**
     * <p>
     * Validate the parameters provided by the client. Called by the {@link AuthorizationEndpoint} and also by the
     * {@link TokenEndpoint} before a response is sent back to the client. Note that during an authorization code flow
     * both endpoints will call this method, but the TokenEndpoint in that case has very little if anything to validate
     * since all the parameters neeeded for the access token were provided to the AuthorizationEndpoint.
     * </p>
     *
     * <p>
     * Implementations should at a minimum check that the scope values requested are legal for the client.
     * </p>
     *
     * @param parameters the request parameters
     * @param clientDetails the client requesting the token
     */
    void validateParameters(Map<String, String> parameters, ClientDetails clientDetails);

}