package edu.kilabs.trv.fixtures;

import edu.kilabs.trv.model.db.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DbHelpers {

    // -----------------------------------------------------------------------------------------------------------------

    public static Build generateSampleBuild(){

        Build result = new Build();
        result.setName("Sample Build Name");

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static TestRun generateSampleTestRun(){

        TestRun result = new TestRun();
        result.setBuild(generateSampleBuild());
        result.setStartTime(ZonedDateTime.now(ZoneId.systemDefault()));

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static TestRun generateSampleTestRunWithTestResults(){

        TestRun result = generateSampleTestRun();
        addSampleTestResults(result);

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static void addSampleTestResults(TestRun testRun) {

        testRun.addTestResult(getSampleTestResult("Sample Test A."));
        testRun.addTestResult(getSampleTestResult("Sample Test B."));

    }

    // -----------------------------------------------------------------------------------------------------------------

    public static TestResult getSampleTestResult(String testName) {

        TestResult result = new TestResult();
        result.setResult(TestResultOutcome.PASS);
        result.setTest(getSampleTest(testName));

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static Test getSampleTest(String testName) {

        Test result = new Test();
        result.setTestName(testName);

        return result;

    }

    // -----------------------------------------------------------------------------------------------------------------

}
