package com.hikarukimi.shortLink.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;

/**
 * @author Hikarukimi
 */
public class PhoneAnonymization extends JsonSerializer<String> {

    /**
     * 对手机号进行脱敏
     */
    @Override
    public void serialize(String string, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        String phone = string.substring(0, 3) + "****" + string.substring(7, 11);
        jsonGenerator.writeString(phone);
    }
}
