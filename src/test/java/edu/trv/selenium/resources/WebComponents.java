package edu.trv.selenium.resources;

public enum WebComponents {

    // -----------------------------------------------------------------------------------------------------------------

      VAADIN_TABS("vaadin-tabs")
    , VAADIN_TAB("vaadin-tab")
    , IRON_ICON("iron-icon");

    // -----------------------------------------------------------------------------------------------------------------

    private final String value;

    // -----------------------------------------------------------------------------------------------------------------

    WebComponents(String value){
        this.value = value;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return value;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
