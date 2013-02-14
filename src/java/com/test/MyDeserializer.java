package com.test;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.deser.std.StdDeserializer;

import java.io.IOException;

public final class MyDeserializer extends StdDeserializer<GoogleJsonResponse> {

    public MyDeserializer() {
        super(GoogleJsonResponse.class);
    }

    @Override
    public GoogleJsonResponse deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
            JsonProcessingException {
        System.out.println("JSON DESERIALIZER-------------------------------------");
        return new GoogleJsonResponseDummy();
    }
}