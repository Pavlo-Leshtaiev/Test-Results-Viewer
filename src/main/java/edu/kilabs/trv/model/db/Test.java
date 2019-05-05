package edu.kilabs.trv.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Test {

    // -----------------------------------------------------------------------------------------------------------------

    @Id
    @GeneratedValue
    @Column(name = "TEST_ID", unique = true, nullable = false)
    private Long id;

    @Column(unique = true, nullable = false)
    private String testName;

    // -----------------------------------------------------------------------------------------------------------------

    public Test(){}

    public Test(String name) {
        testName = name;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Test test = (Test) o;
        return Objects.equals(testName, test.testName);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(testName);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", testName='" + testName + '\'' +
                '}';
    }

    // -----------------------------------------------------------------------------------------------------------------

}
