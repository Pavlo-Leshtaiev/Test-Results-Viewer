package edu.trv.selenium.model.pages;

import edu.trv.selenium.model.base.Locator;
import edu.trv.selenium.model.components.Label;
import edu.trv.selenium.model.components.Tab;
import edu.trv.view.roottab.AboutTab;
import org.openqa.selenium.By;

public class AboutTabContent extends Tab {

    // -----------------------------------------------------------------------------------------------------------------

    private Label authorLabel;
    private Label authorName;
    private Label copyright;
    private final Locator contentLocator;

    // -----------------------------------------------------------------------------------------------------------------

    public AboutTabContent(Locator locator) {
        super(locator);
        contentLocator = Locator.id(AboutTab.ID);
        authorLabel = Label.of(contentLocator.ofChild(By.id(AboutTab.AUTHOR_LABEL_ID)));
        authorName = Label.of(contentLocator.ofChild(By.id(AboutTab.AUTHOR_NAME_ID)));
        copyright = Label.of(contentLocator.ofChild(By.id(AboutTab.COPYRIGHT_ID)));
    }

    // -----------------------------------------------------------------------------------------------------------------

    public String getAuthorLabel() {
        return authorLabel.getText();
    }

    // -----------------------------------------------------------------------------------------------------------------

    public String getAuthorName() {
        return authorName.getText();
    }

    // -----------------------------------------------------------------------------------------------------------------

    public String getCopyright() {
        return copyright.getText();
    }

    // -----------------------------------------------------------------------------------------------------------------

}
