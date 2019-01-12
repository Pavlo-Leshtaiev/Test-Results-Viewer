package esw.edu.trv.repository;

import esw.edu.trv.model.TestRun;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRunRepo extends JpaRepository<TestRun, Long> {
}