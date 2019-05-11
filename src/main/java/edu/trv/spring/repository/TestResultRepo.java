package edu.trv.spring.repository;

import edu.trv.model.db.TestResult;
import edu.trv.model.db.TestResultOutcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepo extends JpaRepository<TestResult, Long> {

    long countByResult(TestResultOutcome result);

}