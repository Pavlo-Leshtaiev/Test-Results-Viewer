package edu.trv.selenium.helpers;

import java.text.MessageFormat;

public class AttributeConverter {

    // -----------------------------------------------------------------------------------------------------------------

    public static boolean toBool(String value){
        if ("false".equals(value)) {
            return false;
        } else if ("true".equals(value)) {
            return true;
        } else {
            throw new IllegalArgumentException(
                    MessageFormat.format("Cannot convert ''{0}'' value to boolean. Unknown value.", value));
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

}
