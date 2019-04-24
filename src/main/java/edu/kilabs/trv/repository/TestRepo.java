package edu.kilabs.trv.repository;

import edu.kilabs.trv.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Test, Long> {
}