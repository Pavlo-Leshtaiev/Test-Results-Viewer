package edu.trv.spring.repository;

import edu.trv.model.db.Build;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BuildRepo extends JpaRepository<Build, Long> {

    Optional<Build> findByName(String name);

}