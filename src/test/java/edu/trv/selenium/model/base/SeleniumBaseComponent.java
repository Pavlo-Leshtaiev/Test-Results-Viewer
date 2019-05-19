package edu.trv.selenium.model.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumBaseComponent {

    // -----------------------------------------------------------------------------------------------------------------

    private final Locator locator;
    private WebElement webElement = null;

    // -----------------------------------------------------------------------------------------------------------------

    public SeleniumBaseComponent(Locator locator) {
        this.locator = locator;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public SeleniumBaseComponent(By locator) {
        this.locator = new Locator(locator);
    }

    // -----------------------------------------------------------------------------------------------------------------

    protected WebElement getWebElement() {
        if (webElement == null) {
            webElement = locator.toWebElement();
        }
        return webElement;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public Locator getLocator() {
        return locator;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void click() {
        getWebElement().click();
    }

    // -----------------------------------------------------------------------------------------------------------------

}
