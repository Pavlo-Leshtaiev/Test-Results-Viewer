package edu.kilabs.trv.model.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Build {

    // -----------------------------------------------------------------------------------------------------------------

    @Id
    @GeneratedValue
    @Column(name = "BUILD_ID", unique = true, nullable = false)
    private Long id;

    private String name;

    // -----------------------------------------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Build build = (Build) o;
        return id.equals(build.id) &&
                Objects.equals(name, build.name);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "Build{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    // -----------------------------------------------------------------------------------------------------------------

}