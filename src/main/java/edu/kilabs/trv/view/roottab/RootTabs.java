package edu.kilabs.trv.view.roottab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.services.SdsKeys;
import edu.kilabs.trv.services.StatePersistenceService;

import java.util.*;

@SpringComponent
@UIScope
public class RootTabs extends Tabs {

    // -----------------------------------------------------------------------------------------------------------------

    private Div pages;
    private Map<Tab, Component> tabsToPages = new HashMap<>();
    private Map<Tab, TabIndex> tabsToIndex = new HashMap<>();
    private Map<TabIndex, Tab> indexToTabs = new HashMap<>();
    private Set<Component> pagesShown = new HashSet<>();

    private StatePersistenceService sps;

    // -----------------------------------------------------------------------------------------------------------------

    public RootTabs(StatisticsTab statisticsTab,
                    LanguageTab languageTab,
                    TestResultsTab testResultsTab,
                    AboutTab aboutTab,
                    StatePersistenceService sps){

        this.sps = sps;

        initPages(testResultsTab, statisticsTab, languageTab, aboutTab);

        addSelectedChangeListener(event -> {
            switchTabs();
            saveSelectedTab();
        });

        restoreSelectedTab();

    }

    // -----------------------------------------------------------------------------------------------------------------

    private void restoreSelectedTab() {

        TabIndex currentIndex = sps.getTabIndex(SdsKeys.CURRENT_ROOT_TAB, TabIndex.ABOUT);
        setSelectedTab(indexToTabs.get(currentIndex));

    }

    // -----------------------------------------------------------------------------------------------------------------

    private void saveSelectedTab() {
        sps.save(SdsKeys.CURRENT_ROOT_TAB, tabsToIndex.get(getSelectedTab()));
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void switchTabs() {
        pagesShown.forEach(page -> page.setVisible(false));
        pagesShown.clear();
        Component selectedPage = tabsToPages.get(this.getSelectedTab());
        selectedPage.setVisible(true);
        pagesShown.add(selectedPage);
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
            add(tab);
            Component content = tab.getContent();
            content.setVisible(false);
            pages.add(content);
            tabsToPages.put(tab, content);
            tabsToIndex.put(tab, tab.getIndex());
            indexToTabs.put(tab.getIndex(), tab);
        }
        this.pages = pages;

    }

    // -----------------------------------------------------------------------------------------------------------------

}
