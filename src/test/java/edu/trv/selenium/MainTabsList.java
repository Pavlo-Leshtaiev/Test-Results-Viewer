package edu.trv.selenium;

import edu.trv.Application;
import edu.trv.fixtures.RestHelpers;
import edu.trv.selenium.configurations.MainPageConfiguration;
import edu.trv.selenium.model.components.Tab;
import edu.trv.selenium.model.pages.MainPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;

/*

    000 - Check Tabs count

 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(
      classes = {Application.class, MainPageConfiguration.class}
    , webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainTabsList {

    // -----------------------------------------------------------------------------------------------------------------



    @Autowired
    private MainPage mainPage;

    @Autowired
    private WebDriver driver;

    @LocalServerPort
    private int port;

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_tabsNumber(){

        driver.get(RestHelpers.toLocalRestUrl(port));

        List<Tab> tabs = mainPage.getMainTabsList().getTabs();

        assertEquals("Incorrect number of tabs", 4, tabs.size());

    }

    // -----------------------------------------------------------------------------------------------------------------

}
