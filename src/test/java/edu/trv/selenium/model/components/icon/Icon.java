package edu.trv.selenium.model.components.icon;

import edu.trv.selenium.model.base.Locator;
import edu.trv.selenium.model.base.SeleniumBaseComponent;

public class Icon extends SeleniumBaseComponent {

    // -----------------------------------------------------------------------------------------------------------------

    private static final String ICON_ATTRIBUTE = "icon";

    // -----------------------------------------------------------------------------------------------------------------

    private Icon(Locator locator) {
        super(locator);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static Icon of(Locator locator) {
        return new Icon(locator);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public VaadinIconType getIcon(){
        return VaadinIconType.of(getWebElement().getAttribute(ICON_ATTRIBUTE));
    }

    // -----------------------------------------------------------------------------------------------------------------

}
