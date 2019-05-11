package edu.trv.spring.resources;

/*

    000 - test english locale
    001 - test german locale

*/

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class TextTest {

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_englishLocale(){

        String statisticsTab = "Statistics";
        Locale.setDefault(new Locale("en", "US"));
        Text.refresh();

        assertEquals("Failed to get proper resources from bundle", statisticsTab, Text.STATISTICS.toString());

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T001_germanLocale(){

        String statisticsTab = "Statistiken";
        Locale.setDefault(new Locale("de", "DE"));
        Text.refresh();

        assertEquals("Failed to get german translation", statisticsTab, Text.STATISTICS.toString());

    }

    // -----------------------------------------------------------------------------------------------------------------

}
