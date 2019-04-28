package edu.kilabs.trv.resources;

import java.util.ResourceBundle;

public enum Text {

    STATISTICS("statistics"),
    LANGUAGE("language"),
    TEST_RESULTS("test_results"),
    ABOUT("about"),
    AUTHOR("author"),

    NUMBER_OF_TESTS("number_of_tests"),
    NUMBER_OF_TEST_RESULTS("number_of_test_results"),
    NUMBER_OF_PASS_TESTS("number_of_pass_tests"),
    NUMBER_OF_FAIL_TESTS("number_of_fail_results"),
    AVERAGE_PASS_RATE("average_pass_rate"),

    PLEASE_SELECT_TESTRUN("please_select_testrun"),
    COMPARE_WITH_RUN("compare_with_run"),
    NAME_COLUMN("name_column"),
    RESULT_COLUMN("result_column"),
    OLD_RESULT_COLUMN("old_result_column"),
    NEW_RESULT_COLUMN("new_result_column"),
    COMPARISON_RESULT_COLUMN("comparison_result_column"),

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
