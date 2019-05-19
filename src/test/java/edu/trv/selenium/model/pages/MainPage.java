package edu.trv.selenium.model.pages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MainPage {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private MainTabsList mainTabsList;

    // -----------------------------------------------------------------------------------------------------------------

    public MainTabsList getMainTabsList() {
        return mainTabsList;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
