package edu.kilabs.trv.model;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
public class TestRun {

    // -----------------------------------------------------------------------------------------------------------------

    @Id
    @GeneratedValue
    @Column(name = "TEST_RUN_ID", unique = true, nullable = false)
    private Long id;

    private ZonedDateTime startTime;

    @ManyToOne()
    @JoinColumn(name = "BUILD_ID", nullable = false)
    private Build build;

    @OneToMany(mappedBy = "testRun")
    private List<TestResult> testResults;

    // -----------------------------------------------------------------------------------------------------------------

    public List<TestResult> getTestResults() {
        return testResults;
    }

    public TestRun() {
    }

    public TestRun(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public Build getBuild() {
        return build;
    }

    public void setBuild(Build build) {
        this.build = build;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public void setTestResults(List<TestResult> testResults) {
        this.testResults = testResults;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void addTestResult(TestResult testResult){
        if (testResults == null) {
            testResults = new LinkedList<>();
        }
        testResults.add(testResult);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestRun testRun = (TestRun) o;
        return id.equals(testRun.id) &&
                Objects.equals(startTime, testRun.startTime) &&
                build.equals(testRun.build) &&
                Objects.equals(testResults, testRun.testResults);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(id, startTime, build, testResults);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "TestRun{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", build=" + build +
                ", testResults=" + testResults +
                '}';
    }

    // -----------------------------------------------------------------------------------------------------------------

}
