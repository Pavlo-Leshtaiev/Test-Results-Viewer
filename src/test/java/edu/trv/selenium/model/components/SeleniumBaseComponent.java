package edu.trv.selenium.model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

public class SeleniumBaseComponent {

    // -----------------------------------------------------------------------------------------------------------------

    private final By selector;
    private WebElement webElement = null;

    @Autowired
    private WebDriver webDriver;

    // -----------------------------------------------------------------------------------------------------------------

    public SeleniumBaseComponent(By selector) {
        this.selector = selector;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public WebElement getWebElement() {
        if (webElement == null) {
            webElement = webDriver.findElement(selector);
        }
        return webElement;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
