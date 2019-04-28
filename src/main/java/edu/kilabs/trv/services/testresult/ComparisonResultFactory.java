package edu.kilabs.trv.services.testresult;

import edu.kilabs.trv.model.backend.ComparisonResult;
import edu.kilabs.trv.model.backend.TestResultComparisonOutcome;
import edu.kilabs.trv.model.db.TestResult;
import edu.kilabs.trv.model.db.TestResultOutcome;
import org.springframework.stereotype.Service;

@Service
public class ComparisonResultFactory {

    // -----------------------------------------------------------------------------------------------------------------

    public ComparisonResult toComparisonResult(TestResult testResult) {
        return new ComparisonResult(
                  testResult.getTest().getTestName()
                , testResult.getResult()
                , TestResultOutcome.NOT_RUN
                , TestResultComparisonOutcome.NOT_RUN
        );
    }

    // -----------------------------------------------------------------------------------------------------------------

    public ComparisonResult compare(TestResult testResultOld, TestResult testResultNew) {

        TestResultOutcome oldResult = testResultOld == null ? TestResultOutcome.NOT_RUN : testResultOld.getResult();
        TestResultOutcome newResult = testResultNew == null ? TestResultOutcome.NOT_RUN : testResultNew.getResult();

        return new ComparisonResult(
                  getTestName(testResultOld, testResultNew)
                , oldResult
                , newResult
                , compare(oldResult, newResult)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------

    private String getTestName(TestResult testResultOld, TestResult testResultNew) {

        if (testResultOld != null) {
            return testResultOld.getTest().getTestName();
        }

        if (testResultNew != null) {
            return testResultNew.getTest().getTestName();
        }

        throw new RuntimeException("Unexpected state");

    }

    // -----------------------------------------------------------------------------------------------------------------

    private TestResultComparisonOutcome compare(TestResultOutcome oldResult, TestResultOutcome newResult) {

        if (newResult == TestResultOutcome.NOT_RUN) {
            return TestResultComparisonOutcome.NOT_RUN;
        }

        if (oldResult == newResult) {
            return TestResultComparisonOutcome.NO_CHANGE;
        }

        if (oldResult == TestResultOutcome.NOT_RUN) {
            return TestResultComparisonOutcome.NEW;
        }

        if (newResult == TestResultOutcome.PASS) {
            return TestResultComparisonOutcome.PROGRESS;
        }

        if (newResult == TestResultOutcome.FAIL) {
            return TestResultComparisonOutcome.REGRESS;
        }

        throw new RuntimeException(
                "Unexpected combination of results: "
                + oldResult.toString() + ", " + newResult.toString());

    }

    // -----------------------------------------------------------------------------------------------------------------

}
