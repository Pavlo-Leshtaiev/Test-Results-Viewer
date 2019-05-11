package edu.trv.spring.repository;

import edu.trv.model.db.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TestRepo extends JpaRepository<Test, Long> {

    Optional<Test> findByTestName(String testName);

}