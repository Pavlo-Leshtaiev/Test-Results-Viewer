package edu.trv.selenium.model.pages;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainPage {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private MainTabsList mainTabsList;

    @Autowired
    private WebDriver driver;

    // -----------------------------------------------------------------------------------------------------------------

    public MainTabsList getMainTabsList() {
        return mainTabsList;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
