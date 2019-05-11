package edu.trv.model.backend;

public class Statistics {

    // -----------------------------------------------------------------------------------------------------------------

    private long numTests;
    private long numTestResults;
    private long numPassTests;
    private long numFailedTests;
    private long averagePassRate;

    // -----------------------------------------------------------------------------------------------------------------

    public long getNumTests() {
        return numTests;
    }

    public void setNumTests(long numTests) {
        this.numTests = numTests;
    }

    public long getNumTestResults() {
        return numTestResults;
    }

    public void setNumTestResults(long numTestResults) {
        this.numTestResults = numTestResults;
    }

    public long getNumPassTests() {
        return numPassTests;
    }

    public void setNumPassTests(long numPassTests) {
        this.numPassTests = numPassTests;
    }

    public long getNumFailedTests() {
        return numFailedTests;
    }

    public void setNumFailedTests(long numFailedTests) {
        this.numFailedTests = numFailedTests;
    }

    public long getAveragePassRate() {
        return averagePassRate;
    }

    public void setAveragePassRate(long averagePassRate) {
        this.averagePassRate = averagePassRate;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
