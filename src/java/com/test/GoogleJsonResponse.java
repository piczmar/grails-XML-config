package com.test;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.Date;
import java.util.Map;
import java.util.Set;

/**
 * @author Dave Syer
 *
 */
@JsonSerialize(using = MySerializer.class)
@JsonDeserialize(using = MyDeserializer.class)
public interface GoogleJsonResponse {

    public static String BEARER_TYPE = "Bearer";

    public static String OAUTH2_TYPE = "OAuth2";

    /**
     * The access token issued by the authorization server. This value is REQUIRED.
     */
    public static String ACCESS_TOKEN = "access_token";

    /**
     * The type of the token issued as described in <a
     * href="http://tools.ietf.org/html/draft-ietf-oauth-v2-22#section-7.1">Section 7.1</a>. Value is case insensitive.
     * This value is REQUIRED.
     */
    public static String TOKEN_TYPE = "token_type";

    /**
     * The lifetime in seconds of the access token. For example, the value "3600" denotes that the access token will
     * expire in one hour from the time the response was generated. This value is OPTIONAL.
     */
    public static String EXPIRES_IN = "expires_in";

    /**
     * The scope of the access token as described by <a
     * href="http://tools.ietf.org/html/draft-ietf-oauth-v2-22#section-3.3">Section 3.3</a>
     */
    public static String SCOPE = "scope";

    Map<String, Object> getAdditionalInformation();

    Set<String> getScope();

    String getTokenType();

    boolean isExpired();

    Date getExpiration();

    int getExpiresIn();

    String getValue();

}
