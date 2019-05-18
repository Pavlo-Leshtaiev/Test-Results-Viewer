package edu.trv.selenium.model.components.icon;

import edu.trv.selenium.model.components.SeleniumBaseComponent;
import org.openqa.selenium.WebElement;

public class Icon extends SeleniumBaseComponent {

    // -----------------------------------------------------------------------------------------------------------------

    private static final String ICON_ATTRIBUTE = "icon";

    // -----------------------------------------------------------------------------------------------------------------

    public Icon(WebElement iconWebElement) {
        super(iconWebElement);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static Icon of(WebElement webElement) {
        return new Icon(webElement);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public VaadinIconType getIcon(){
        return VaadinIconType.of(getWebElement().getAttribute(ICON_ATTRIBUTE));
    }

    // -----------------------------------------------------------------------------------------------------------------

}
