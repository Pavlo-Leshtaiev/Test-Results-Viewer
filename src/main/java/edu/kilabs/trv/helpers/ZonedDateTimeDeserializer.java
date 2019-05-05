package edu.kilabs.trv.helpers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

class ZonedDateTimeDeserializer extends JsonDeserializer<ZonedDateTime> {

    // -----------------------------------------------------------------------------------------------------------------

    private final DateTimeFormatter dateTimeFormatter;

    // -----------------------------------------------------------------------------------------------------------------

    public ZonedDateTimeDeserializer(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Class<?> handledType() {
        return ZonedDateTime.class;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public ZonedDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws
            IOException {
        return ZonedDateTime.parse(jsonParser.getText(), dateTimeFormatter);
    }

    // -----------------------------------------------------------------------------------------------------------------

}
