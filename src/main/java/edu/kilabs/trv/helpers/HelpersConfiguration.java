package edu.kilabs.trv.helpers;

import edu.kilabs.trv.resources.Text;
import org.springframework.beans.factory.annotation.Qualifier;
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

}
