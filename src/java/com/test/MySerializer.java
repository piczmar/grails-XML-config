package com.test;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.std.SerializerBase;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.Set;

public final class MySerializer extends SerializerBase<GoogleJsonResponse> {

    public MySerializer() {
        super(GoogleJsonResponse.class);
    }

    @Override
    public void serialize(GoogleJsonResponse token, JsonGenerator jgen, SerializerProvider provider) throws IOException,
            JsonGenerationException {
        System.out.println("JSON SERIALIZER-------------------------------------");
        jgen.writeStartObject();
        jgen.writeStringField(GoogleJsonResponse.ACCESS_TOKEN, token.getValue());
        jgen.writeStringField(GoogleJsonResponse.TOKEN_TYPE, token.getTokenType());

        Date expiration = token.getExpiration();
        if (expiration != null) {
            long now = System.currentTimeMillis();
            jgen.writeNumberField(GoogleJsonResponse.EXPIRES_IN, (expiration.getTime() - now) / 1000);
        }
        Set<String> scope = token.getScope();
        if (scope != null && !scope.isEmpty()) {
            StringBuffer scopes = new StringBuffer();
            for (String s : scope) {
                scopes.append(s);
                scopes.append(" ");
            }
            jgen.writeStringField(GoogleJsonResponse.SCOPE, scopes.substring(0, scopes.length() - 1));
        }
        Map<String, Object> additionalInformation = token.getAdditionalInformation();
        for (String key : additionalInformation.keySet()) {
            jgen.writeObjectField(key, additionalInformation.get(key));
        }
        jgen.writeEndObject();
    }
}