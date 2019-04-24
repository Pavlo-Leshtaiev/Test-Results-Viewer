package edu.kilabs.trv.resources;

import java.util.ResourceBundle;

public enum Text {

    STATISTICS("statistics"),
    LANGUAGE("language"),
    TEST_RESULTS("test_results"),
    ABOUT("about"),
    AUTHOR("author"),

    PLEASE_SELECT_TESTRUN("please_select_testrun"),

    LANG_ENG("language_english"),
    LANG_GER("language_german"),
    LANG_RUS("language_russian"),

    TIME_FORMAT_FULL("time_format_full"),

    MSG_TEST_RUN_NAME("msg_test_run_name");

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
