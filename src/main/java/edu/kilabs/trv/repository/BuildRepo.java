package edu.kilabs.trv.repository;

import edu.kilabs.trv.model.db.Build;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildRepo extends JpaRepository<Build, Long> {
}