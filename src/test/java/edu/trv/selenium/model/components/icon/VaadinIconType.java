package edu.trv.selenium.model.components.icon;

import java.util.HashMap;
import java.util.Map;

public enum VaadinIconType {

    // -----------------------------------------------------------------------------------------------------------------

      GRID("vaadin:grid")
    , WRENCH("vaadin:wrench")
    , QUESTION("vaadin:question")
    , PIE_CHART("vaadin:pie-chart");

    // -----------------------------------------------------------------------------------------------------------------

    private final String name;
    private static final Map<String, VaadinIconType> typesByName = new HashMap<>();

    // -----------------------------------------------------------------------------------------------------------------

    VaadinIconType(String iconName) {
        this.name = iconName;
    }

    // -----------------------------------------------------------------------------------------------------------------

    static {
        for (VaadinIconType type : VaadinIconType.values()) {
            typesByName.put(type.name, type);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static VaadinIconType of(String iconName) {
        return typesByName.get(iconName);
    }

    // -----------------------------------------------------------------------------------------------------------------

}
