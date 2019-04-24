package edu.kilabs.trv.repository;

import edu.kilabs.trv.model.db.TestResult;
import edu.kilabs.trv.model.db.TestResultOutcome;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepo extends JpaRepository<TestResult, Long> {

    long countByResult(TestResultOutcome result);

}