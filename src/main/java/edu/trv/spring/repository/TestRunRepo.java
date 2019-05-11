package edu.trv.spring.repository;

import edu.trv.model.db.TestRun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRunRepo extends JpaRepository<TestRun, Long> {
}