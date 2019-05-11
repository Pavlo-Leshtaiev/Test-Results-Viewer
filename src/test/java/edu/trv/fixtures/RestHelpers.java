package edu.trv.fixtures;

public class RestHelpers {

    public static final String REST_ROOT = "/api/rest/";
    public static final String TESTRUN = REST_ROOT + "testrun";
    public static final String TESTRUNS = REST_ROOT + "testruns";

    // -----------------------------------------------------------------------------------------------------------------

    public static String toLocalRestUrl(int port) {
        return "http://localhost:" + port;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
