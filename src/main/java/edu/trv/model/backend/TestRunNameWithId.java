package edu.trv.model.backend;

public class TestRunNameWithId {

    // -----------------------------------------------------------------------------------------------------------------

    private final String name;
    private final long id;

    // -----------------------------------------------------------------------------------------------------------------

    public TestRunNameWithId(String name, long id){
        this.name = name;
        this.id = id;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static TestRunNameWithId of(String name, long id) {
        return new TestRunNameWithId(name, id);
    }

    // -----------------------------------------------------------------------------------------------------------------

}
