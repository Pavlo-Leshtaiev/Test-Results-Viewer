package edu.trv.selenium.model.base;

import edu.trv.selenium.model.infrastructure.ChromeWebDriverConfiguration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Locator {

    // -----------------------------------------------------------------------------------------------------------------

    private List<By> bys = new LinkedList<>();

    // -----------------------------------------------------------------------------------------------------------------

    public Locator(By locator){
        bys.add(locator);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public Locator(Locator parent, By child){
        bys.addAll(parent.bys);
        bys.add(child);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static Locator id(String id) {
        return new Locator(By.id(id));
    }

    // -----------------------------------------------------------------------------------------------------------------

    public static Locator xpath(String xpath) {
        return new Locator(By.xpath(xpath));
    }

    // -----------------------------------------------------------------------------------------------------------------

    public Locator ofChild(By locator) {
        return new Locator(this, locator);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public WebElement toWebElement(){

        Iterator<By> iterator = bys.iterator();
        WebElement element = ChromeWebDriverConfiguration.driver.findElement(iterator.next());
        while(iterator.hasNext()){
            element = element.findElement(iterator.next());
        }
        return element;

    }

    // -----------------------------------------------------------------------------------------------------------------

}
