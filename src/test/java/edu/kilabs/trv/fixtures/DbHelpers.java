package edu.kilabs.trv.fixtures;

import edu.kilabs.trv.model.db.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

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
        result.setTestResults(getSampleTestResults());

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static List<TestResult> getSampleTestResults() {

        List<TestResult> result = new LinkedList<>();
        result.add(getSampleTestResult("Sample Test A."));
        result.add(getSampleTestResult("Sample Test B."));

        return result;

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
