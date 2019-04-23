package edu.kilabs.trv.resources;

import java.util.ResourceBundle;

public enum Text {

    STATISTICS("statistics");

    static ResourceBundle bundle = getBundle();

    private final String key;

    Text(String resourceKey){
        this.key = resourceKey;
    }

    @Override
    public String toString() {
        return bundle.getString(this.key);
    }

    private static ResourceBundle getBundle(){
        return ResourceBundle.getBundle("i18n/main_text");
    }

    public static void refresh(){
        bundle = getBundle();
    }

}
