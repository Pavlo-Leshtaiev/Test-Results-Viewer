package edu.kilabs.trv.repository;

import edu.kilabs.trv.model.db.TestRun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRunRepo extends JpaRepository<TestRun, Long> {
}