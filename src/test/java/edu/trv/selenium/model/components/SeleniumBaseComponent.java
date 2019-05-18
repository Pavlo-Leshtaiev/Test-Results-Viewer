package edu.trv.selenium.model.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;

public class SeleniumBaseComponent {

    // -----------------------------------------------------------------------------------------------------------------

    private final By selector;
    protected WebElement webElement = null;

    @Autowired
    private WebDriver webDriver;

    // -----------------------------------------------------------------------------------------------------------------

    public SeleniumBaseComponent(By selector) {
        this.selector = selector;
    }

    // -----------------------------------------------------------------------------------------------------------------

    protected SeleniumBaseComponent(WebElement webElement) {
        this.selector = null;
        this.webElement = webElement;
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
