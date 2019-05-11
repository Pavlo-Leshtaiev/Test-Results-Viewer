package edu.trv.selenium.model.components;

import edu.trv.selenium.resources.WebComponents;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class TabsList extends SeleniumBaseComponent {

    // -----------------------------------------------------------------------------------------------------------------

    public TabsList(By selector){
        super(selector);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public List<Tab> getTabs(){

        return getWebElement().findElements(By.tagName(WebComponents.VAADIN_TAB.toString()))
                .stream()
                .map(Tab::ofWebElement)
                .collect(Collectors.toList());
    }

    // -----------------------------------------------------------------------------------------------------------------

}
