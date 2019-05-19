package edu.trv.selenium.testcases;

import edu.trv.selenium.model.components.Tab;
import edu.trv.selenium.model.components.icon.Icon;
import edu.trv.selenium.model.components.icon.VaadinIconType;
import edu.trv.selenium.model.pages.MainPage;
import edu.trv.selenium.model.pages.MainTabsList;
import edu.trv.spring.resources.Text;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/*

    000 - Check Tabs count
    001 - Check Tabs names
    002 - Check Tabs icons
    003 - Check Tabs selection

*/
public class MainTabsListTest extends AbstractSeleniumTestCase {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private MainPage mainPage;

    private static boolean init = false;

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

    @Test
    public void T003_tabsSelection(){

        MainTabsList mainTabsList = mainPage.getMainTabsList();
        List<Tab> tabs = mainTabsList.getTabs();

        var aboutTab = mainTabsList.openAboutTab();
        assertTrue("About Tab should be selected", aboutTab.isSelected());

        var languageTab = mainTabsList.openLanguageTab();
        assertTrue("Language Tab should be selected", languageTab.isSelected());
        assertFalse("About Tab should not be selected", aboutTab.isSelected());

        mainTabsList.openAboutTab();
        assertFalse("Language Tab should not be selected", languageTab.isSelected());
        assertTrue("About Tab should be selected", aboutTab.isSelected());

    }

    // -----------------------------------------------------------------------------------------------------------------

}
