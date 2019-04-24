package edu.kilabs.trv.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class TestResult {

    @Id
    @GeneratedValue
    @Column(name = "TEST_RESULT_ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "TEST_RUN_ID", nullable = false)
    private TestRun testRun;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "TEST_ID", nullable = false)
    private Test test;

    @Enumerated
    @Column(columnDefinition = "smallint", nullable = false)
    private TestResultOutcome result;

    // -----------------------------------------------------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestRun getTestRun() {
        return testRun;
    }

    public void setTestRun(TestRun testRun) {
        this.testRun = testRun;
    }

    public TestResultOutcome getResult() {
        return result;
    }

    public void setResult(TestResultOutcome result) {
        this.result = result;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestResult that = (TestResult) o;
        return id.equals(that.id) &&
                testRun.equals(that.testRun) &&
                test.equals(that.test) &&
                result == that.result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(id, testRun, test, result);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", testRun=" + testRun +
                ", test=" + test +
                ", result=" + result +
                '}';
    }

    // -----------------------------------------------------------------------------------------------------------------

}
