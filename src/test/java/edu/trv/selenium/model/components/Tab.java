package edu.trv.selenium.model.components;

import edu.trv.selenium.helpers.AttributeConverter;
import edu.trv.selenium.model.base.Locator;
import edu.trv.selenium.model.base.SeleniumBaseComponent;
import edu.trv.selenium.model.components.icon.Icon;
import edu.trv.selenium.resources.WebComponents;
import org.openqa.selenium.By;

public class Tab extends SeleniumBaseComponent {

    // -----------------------------------------------------------------------------------------------------------------

    private static final String SELECTED = "aria-selected";

    // -----------------------------------------------------------------------------------------------------------------

    private Icon icon;

    // -----------------------------------------------------------------------------------------------------------------

    public Tab(Locator locator) {
        super(locator);
        icon = Icon.of(getLocator().ofChild(By.tagName(WebComponents.IRON_ICON.toString())));
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static Tab of(Locator locator) {
        return new Tab(locator);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public String getName() {
        return getWebElement().getText();
    }

    // -----------------------------------------------------------------------------------------------------------------

    public Icon getIcon() {
        return icon;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public boolean isSelected() {
        return AttributeConverter.toBool(
                getWebElement().getAttribute(SELECTED));
    }

    // -----------------------------------------------------------------------------------------------------------------

}
