package edu.kilabs.trv.helpers;

import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import edu.kilabs.trv.resources.Text;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;
import java.util.function.Supplier;

@Configuration
public class HelpersConfiguration {

    // -----------------------------------------------------------------------------------------------------------------

    @Bean
    @Qualifier("dateTimeFormatterFactory")
    public Supplier<DateTimeFormatter> dateTimeFormatterFactory(){
        return () -> DateTimeFormatter.ofPattern(Text.TIME_FORMAT_FULL.toString());
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonCustomizer(Supplier<DateTimeFormatter> dateTimeFormatterFactory) {

        DateTimeFormatter dateTimeFormatter = dateTimeFormatterFactory.get();

        return builder -> {
            builder.serializers(new ZonedDateTimeSerializer(dateTimeFormatter));
            builder.deserializers(new ZonedDateTimeDeserializer(dateTimeFormatter));
        };

    }

    // -----------------------------------------------------------------------------------------------------------------

}
