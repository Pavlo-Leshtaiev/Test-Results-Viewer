package edu.kilabs.trv.view.roottab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SpringComponent
@UIScope
public class RootTabs extends Tabs {

    // -----------------------------------------------------------------------------------------------------------------

    private Div pages;
    private Map<Tab, Component> tabsToPages = new HashMap<>();
    private Set<Component> pagesShown = new HashSet<>();

    // -----------------------------------------------------------------------------------------------------------------

    public RootTabs(StatisticsTab statisticsTab,
                    LanguageTab languageTab,
                    TestResultsTab testResultsTab,
                    AboutTab aboutTab){

        this.add(testResultsTab);
        this.add(statisticsTab);
        this.add(languageTab);
        this.add(aboutTab);

        initPages(statisticsTab, languageTab, testResultsTab, aboutTab);

        addSelectedChangeListener(event -> {
            pagesShown.forEach(page -> page.setVisible(false));
            pagesShown.clear();
            Component selectedPage = tabsToPages.get(this.getSelectedTab());
            selectedPage.setVisible(true);
            pagesShown.add(selectedPage);
        });

        setSelectedTab(aboutTab);

    }

    // -----------------------------------------------------------------------------------------------------------------

    public Div getContents(){
        return pages;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @SafeVarargs
    private <T extends Tab & RootTabPage> void initPages(T... tabs){

        Div pages = new Div();
        for (var tab: tabs) {
            Component content = tab.getContent();
            content.setVisible(false);
            pages.add(content);
            tabsToPages.put(tab, content);
        }
        this.pages = pages;

    }

    // -----------------------------------------------------------------------------------------------------------------

}
