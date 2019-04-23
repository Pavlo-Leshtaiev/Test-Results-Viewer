package edu.kilabs.trv.resources;

import java.util.ResourceBundle;

public enum Text {

    STATISTICS("statistics"),
    LANGUAGE("language"),
    TEST_RESULTS("test_results"),
    ABOUT("about"),
    AUTHOR("author"),

    LANG_ENG("language_english"),
    LANG_GER("language_german"),
    LANG_RUS("language_russian");

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
