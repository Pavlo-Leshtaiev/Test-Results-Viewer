package edu.kilabs.trv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Entity
public class TestRun {

    @Id
    @GeneratedValue
    private Long id;

    private ZonedDateTime startTime;

    public TestRun() {
    }

    public TestRun(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public Long getId() {
        return id;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

}
