package edu.trv.selenium;

import edu.trv.Application;
import edu.trv.fixtures.RestHelpers;
import edu.trv.selenium.configurations.MainPageConfiguration;
import edu.trv.selenium.model.components.Tab;
import edu.trv.selenium.model.components.icon.Icon;
import edu.trv.selenium.model.components.icon.VaadinIconType;
import edu.trv.selenium.model.pages.MainPage;
import edu.trv.spring.resources.Text;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/*

    000 - Check Tabs count
    001 - Check Tabs names
    002 - Check Tabs icons

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

    private static boolean init = false;

    // -----------------------------------------------------------------------------------------------------------------

    @BeforeEach
    void getTab(){
        if (!init) {
            driver.get(RestHelpers.toLocalRestUrl(port));
            init = true;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_tabsQuantity(){

        List<Tab> tabs = mainPage.getMainTabsList().getTabs();

        assertEquals("Incorrect number of tabs", 4, tabs.size());

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T001_tabsNames(){

        List<String> tabs = mainPage.getMainTabsList().getTabs()
                .stream()
                .map(Tab::getName)
                .collect(Collectors.toList());

        LinkedList<String> expectedList = new LinkedList<>();
        expectedList.add(Text.TEST_RESULTS.toString());
        expectedList.add(Text.STATISTICS.toString());
        expectedList.add(Text.LANGUAGE.toString());
        expectedList.add(Text.ABOUT.toString());

        assertEquals("Incorrect tabs names",expectedList ,tabs);

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T002_tabsIcons(){

        var icons = mainPage.getMainTabsList().getTabs()
                .stream()
                .map(Tab::getIcon)
                .map(Icon::getIcon)
                .collect(Collectors.toList());

        LinkedList<VaadinIconType> expectedList = new LinkedList<>();
        expectedList.add(VaadinIconType.GRID);
        expectedList.add(VaadinIconType.PIE_CHART);
        expectedList.add(VaadinIconType.WRENCH);
        expectedList.add(VaadinIconType.QUESTION);

        assertEquals("Incorrect icon names", expectedList ,icons);

    }

    // -----------------------------------------------------------------------------------------------------------------

}
