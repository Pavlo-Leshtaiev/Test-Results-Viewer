package edu.trv.selenium.model.pages;

import edu.trv.selenium.model.components.TabsList;
import edu.trv.selenium.resources.WebComponents;
import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class MainTabsList extends TabsList {

    // -----------------------------------------------------------------------------------------------------------------

    public MainTabsList() {
        super(By.tagName(WebComponents.VAADIN_TABS.toString())
                , Arrays.asList(
                    null
                  , null
                  , LanguageTabContent.class
                  , AboutTabContent.class)
        );
    }

    // -----------------------------------------------------------------------------------------------------------------

    public AboutTabContent openAboutTab() {
        return selectTabByClass(AboutTabContent.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public LanguageTabContent openLanguageTab() {
        return selectTabByClass(LanguageTabContent.class);
    }

    // -----------------------------------------------------------------------------------------------------------------

}
