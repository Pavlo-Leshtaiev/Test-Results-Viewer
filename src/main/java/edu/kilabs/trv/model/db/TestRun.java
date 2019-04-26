package edu.kilabs.trv.model.db;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.*;

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

    @OneToMany(mappedBy = "testRun", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<TestResult> testResults = new ArrayList<>();

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
        testResult.setTestRun(this);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestRun testRun = (TestRun) o;
        return id.equals(testRun.id) &&
                startTime.equals(testRun.startTime) &&
                build.equals(testRun.build) &&
                listEquals(testResults, testRun.testResults);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private <T> boolean listEquals(List<T> current, List<T> other) {
        if (current == other) return true;
        if (current == null || other == null) return false;
        if (current.size() != other.size()) return false;
        Iterator<T> it1 = current.iterator();
        Iterator<T> it2 = other.iterator();

        while (it1.hasNext() && it2.hasNext()) {
            if (!it1.next().equals(it2.next())) return false;
        }

        return true;
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
