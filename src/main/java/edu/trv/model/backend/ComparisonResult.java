package edu.trv.model.backend;

import edu.trv.model.db.TestResultOutcome;

import java.util.Objects;

public class ComparisonResult {

    // -----------------------------------------------------------------------------------------------------------------

    private final String testName;
    private final TestResultOutcome oldResult;
    private final TestResultOutcome newResult;
    private final TestResultComparisonOutcome testResultComparisonOutcome;

    // -----------------------------------------------------------------------------------------------------------------

    public ComparisonResult(
              String testName
            , TestResultOutcome oldResult
            , TestResultOutcome newResult
            , TestResultComparisonOutcome testResultComparison) {
        this.testName = testName;
        this.newResult = newResult;
        this.oldResult = oldResult;
        this.testResultComparisonOutcome = testResultComparison;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public String getTestName() {
        return testName;
    }

    public TestResultOutcome getOldResult() {
        return oldResult;
    }

    public TestResultOutcome getNewResult() {
        return newResult;
    }

    public TestResultComparisonOutcome getTestResultComparisonOutcome() {
        return testResultComparisonOutcome;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComparisonResult that = (ComparisonResult) o;
        return testName.equals(that.testName) &&
                oldResult == that.oldResult &&
                newResult == that.newResult &&
                testResultComparisonOutcome == that.testResultComparisonOutcome;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(testName, oldResult, newResult, testResultComparisonOutcome);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "ComparisonResult{" +
                "testName='" + testName + '\'' +
                ", oldResult=" + oldResult +
                ", newResult=" + newResult +
                ", testResultComparisonOutcome=" + testResultComparisonOutcome +
                '}';
    }

    // -----------------------------------------------------------------------------------------------------------------

}
