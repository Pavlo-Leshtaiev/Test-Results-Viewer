package edu.kilabs.trv.repository;

import edu.kilabs.trv.model.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;

class DbHelpers {

    // -----------------------------------------------------------------------------------------------------------------

    static Build generateSampleBuild(){

        Build result = new Build();
        result.setName("Sample Build Name");

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    static TestRun generateSampleTestRun(){

        TestRun result = new TestRun();
        result.setBuild(generateSampleBuild());
        result.setStartTime(ZonedDateTime.now(ZoneId.systemDefault()));

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    static TestRun generateSampleTestRunWithTestResults(){

        TestRun result = generateSampleTestRun();
        result.setTestResults(getSampleTestResults());

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    static List<TestResult> getSampleTestResults() {

        List<TestResult> result = new LinkedList<>();
        result.add(getSampleTestResult("Sample Test A."));
        result.add(getSampleTestResult("Sample Test B."));

        return result;

    }

    // -----------------------------------------------------------------------------------------------------------------

    static TestResult getSampleTestResult(String testName) {

        TestResult result = new TestResult();
        result.setResult(TestResultOutcome.PASS);
        result.setTest(getSampleTest(testName));

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    static Test getSampleTest(String testName) {

        Test result = new Test();
        result.setTestName(testName);

        return result;

    }

    // -----------------------------------------------------------------------------------------------------------------

}
