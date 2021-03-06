package edu.trv.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private TestRun testRun;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
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
        return test.equals(that.test) &&
                result == that.result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(test, result);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "TestResult{" +
                "id=" + id +
                ", test=" + test +
                ", result=" + result +
                '}';
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static TestResult of(Test test, TestResultOutcome result) {
        TestResult testResult = new TestResult();

        testResult.setTest(test);
        testResult.setResult(result);

        return testResult;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
