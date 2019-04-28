package edu.kilabs.trv.services;

import edu.kilabs.trv.Application;
import edu.kilabs.trv.fixtures.DbHelpers;
import edu.kilabs.trv.model.backend.ComparisonResult;
import edu.kilabs.trv.model.backend.TestResultComparisonOutcome;
import edu.kilabs.trv.model.db.TestResult;
import edu.kilabs.trv.model.db.TestResultOutcome;
import edu.kilabs.trv.model.db.TestRun;
import edu.kilabs.trv.services.testresult.TestResultService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/*

    000 - Test results for ID

    100 - Compare only new
    101 - Compare only old
    102 - Compare two result sets

 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class TestResultServiceTest {

    // -----------------------------------------------------------------------------------------------------------------
    
    @Autowired
    TestResultService testResultService;

    @Autowired
    TestRunService trs;

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_testResultsForId(){

        TestRun testRun = DbHelpers.generateSampleTestRunWithTestResults();
        trs.persist(testRun);

        List<ComparisonResult> expectedComparisonResult = testRun.getTestResults()
                .stream()
                .map(tr ->
                    new ComparisonResult(
                          tr.getTest().getTestName()
                        , tr.getResult()
                        , TestResultOutcome.NOT_RUN
                        , TestResultComparisonOutcome.NOT_RUN))
                .collect(Collectors.toList());

        var testResultsForId = testResultService.getTestResultsForId(testRun.getId());

        assertEquals("Incorrect number of elements.", testRun.getTestResults().size(), testResultsForId.size());
        assertEquals("Incorrect elements returned", expectedComparisonResult, testResultsForId);

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T100_compareOnlyOld(){

        // Prepare test data
        TestRun testRun = DbHelpers.generateSampleTestRunWithTestResults();
        trs.persist(testRun);

        TestRun testRunNoResults = DbHelpers.generateSampleTestRun();
        trs.persist(testRunNoResults);

        List<ComparisonResult> expectedComparisonResult = testRun.getTestResults()
                .stream()
                .map(tr ->
                        new ComparisonResult(
                                tr.getTest().getTestName()
                                , tr.getResult()
                                , TestResultOutcome.NOT_RUN
                                , TestResultComparisonOutcome.NOT_RUN))
                .collect(Collectors.toList());

        // Method under test
        var testResultsForId = testResultService.getTestComparisonResultsForIds(
                  testRun.getId()
                , testRunNoResults.getId());

        // Validate the result
        assertEquals("Incorrect number of elements.", testRun.getTestResults().size(), testResultsForId.size());
        assertEquals("Incorrect elements returned", expectedComparisonResult, testResultsForId);

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T101_compareOnlyNew(){

        // Prepare test data
        TestRun testRun = DbHelpers.generateSampleTestRunWithTestResults();
        trs.persist(testRun);

        TestRun testRunNoResults = DbHelpers.generateSampleTestRun();
        trs.persist(testRunNoResults);

        List<ComparisonResult> expectedComparisonResult = testRun.getTestResults()
                .stream()
                .map(tr ->
                        new ComparisonResult(
                                tr.getTest().getTestName()
                                , TestResultOutcome.NOT_RUN
                                , tr.getResult()
                                , TestResultComparisonOutcome.NEW))
                .collect(Collectors.toList());

        // Method under test
        var testResultsForId = testResultService.getTestComparisonResultsForIds(
                  testRunNoResults.getId()
                , testRun.getId());

        // Validate the result
        assertEquals("Incorrect number of elements.", testRun.getTestResults().size(), testResultsForId.size());
        assertEquals("Incorrect elements returned", expectedComparisonResult, testResultsForId);

    }

    // -----------------------------------------------------------------------------------------------------------------

    @ParameterizedTest
    @MethodSource("argumentsForCompareTwoResultSets")
    public void T102_compareTwoResultSets(TestResultOutcome oldResult, TestResultOutcome newResult, TestResultComparisonOutcome comparison){

        // Prepare test data
        var test = DbHelpers.generateSampleTest();
        TestRun testRunOld = DbHelpers.generateSampleTestRun();
        testRunOld.addTestResult(TestResult.of(test, oldResult));
        trs.persist(testRunOld);

        TestRun testRunNew = DbHelpers.generateSampleTestRun();
        testRunNew.addTestResult(TestResult.of(test, newResult));
        trs.persist(testRunNew);

        List<ComparisonResult> expectedComparisonResult = new LinkedList<>();
        expectedComparisonResult.add(new ComparisonResult(test.getTestName(), oldResult, newResult, comparison));

        // Method under test
        var testResultsForId = testResultService.getTestComparisonResultsForIds(
                  testRunOld.getId()
                , testRunNew.getId());

        // Validate the result
        assertEquals("Incorrect number of elements.", testRunOld.getTestResults().size(), testResultsForId.size());
        assertEquals("Incorrect elements returned", expectedComparisonResult, testResultsForId);

    }

    // -----------------------------------------------------------------------------------------------------------------

    private static Stream<Arguments> argumentsForCompareTwoResultSets() {
        return Stream.of(
            Arguments.of(TestResultOutcome.PASS, TestResultOutcome.PASS, TestResultComparisonOutcome.NO_CHANGE),
            Arguments.of(TestResultOutcome.PASS, TestResultOutcome.FAIL, TestResultComparisonOutcome.REGRESS),
            Arguments.of(TestResultOutcome.PASS, TestResultOutcome.NOT_RUN, TestResultComparisonOutcome.NOT_RUN),
            Arguments.of(TestResultOutcome.FAIL, TestResultOutcome.PASS, TestResultComparisonOutcome.PROGRESS),
            Arguments.of(TestResultOutcome.FAIL, TestResultOutcome.FAIL, TestResultComparisonOutcome.NO_CHANGE),
            Arguments.of(TestResultOutcome.FAIL, TestResultOutcome.NOT_RUN, TestResultComparisonOutcome.NOT_RUN),
            Arguments.of(TestResultOutcome.NOT_RUN, TestResultOutcome.PASS, TestResultComparisonOutcome.NEW),
            Arguments.of(TestResultOutcome.NOT_RUN, TestResultOutcome.FAIL, TestResultComparisonOutcome.NEW),
            Arguments.of(TestResultOutcome.NOT_RUN, TestResultOutcome.NOT_RUN, TestResultComparisonOutcome.NOT_RUN)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------

}
