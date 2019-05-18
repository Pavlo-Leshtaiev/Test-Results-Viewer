package edu.trv.selenium.model.components;

import edu.trv.selenium.model.components.icon.Icon;
import edu.trv.selenium.resources.WebComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Tab extends SeleniumBaseComponent {

    // -----------------------------------------------------------------------------------------------------------------

    private Icon icon;

    // -----------------------------------------------------------------------------------------------------------------

    protected Tab(WebElement webElement) {
        super(webElement);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static Tab ofWebElement(WebElement webElement) {

        return new Tab(webElement);

    }

    // -----------------------------------------------------------------------------------------------------------------

    public String getName() {
        return webElement.getText();
    }

    // -----------------------------------------------------------------------------------------------------------------

    public Icon getIcon() {
        if (icon == null) {
            WebElement iconWebElement = getWebElement().findElement(By.tagName(WebComponents.IRON_ICON.toString()));
            icon = Icon.of(iconWebElement);
        }
        return icon;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
