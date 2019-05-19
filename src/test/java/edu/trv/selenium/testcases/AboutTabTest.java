package edu.trv.selenium.testcases;

import edu.trv.selenium.model.pages.AboutTabContent;
import edu.trv.selenium.model.pages.MainPage;
import edu.trv.spring.resources.ConstantData;
import edu.trv.spring.resources.Text;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

/*

    000 - Check About tab elements

 */
public class AboutTabTest extends AbstractSeleniumTestCase {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private MainPage mainPage;

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_aboutTabsElements(){

        AboutTabContent aboutTab = mainPage.getMainTabsList().openAboutTab();
        String authorLabel = aboutTab.getAuthorLabel();
        String author = aboutTab.getAuthorName();
        String copyright = aboutTab.getCopyright();

        assertEquals("Incorrect author", ConstantData.AUTHOR.toString(), author);
        assertEquals("Incorrect copyright", Text.AUTHOR.toString(), authorLabel);
        assertEquals("Incorrect copyright", ConstantData.YEAR.toString(), copyright);

    }

    // -----------------------------------------------------------------------------------------------------------------

}
