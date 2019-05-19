package edu.trv.selenium.model.components;

import edu.trv.selenium.model.base.Locator;
import edu.trv.selenium.model.base.SeleniumBaseComponent;

public class Label extends SeleniumBaseComponent {

    // -----------------------------------------------------------------------------------------------------------------

    private Label(Locator locator) {
        super(locator);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static Label of(Locator locator) {
        return new Label(locator);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public String getText() {
        return getWebElement().getText();
    }

    // -----------------------------------------------------------------------------------------------------------------

}
