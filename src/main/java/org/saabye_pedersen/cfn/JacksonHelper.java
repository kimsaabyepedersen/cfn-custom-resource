package org.saabye_pedersen.cfn;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

class JacksonHelper {

    private static ObjectMapper MAPPER = new ObjectMapper();

    static CfnRequest getInputFromStream(InputStream inputStream) {
        try {
            return MAPPER.readValue(inputStream, CfnRequest.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static <T> String mapToString(T cfnRequest) {
        try {
            return MAPPER.writeValueAsString(cfnRequest);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
