package edu.trv.model.db;

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

    @Column(unique = true, nullable = false)
    private String name;

    // -----------------------------------------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Build build = (Build) o;
        return Objects.equals(name, build.name);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public int hashCode() {
        return Objects.hash(name);
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
