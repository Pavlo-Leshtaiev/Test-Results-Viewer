package edu.kilabs.trv.repository;

import edu.kilabs.trv.model.db.Build;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuildRepo extends JpaRepository<Build, Long> {

    Optional<Build> findByName(String name);

}