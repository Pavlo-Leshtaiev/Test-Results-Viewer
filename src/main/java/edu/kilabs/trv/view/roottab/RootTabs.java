package edu.kilabs.trv.view.roottab;

import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class RootTabs extends Tabs {

    public RootTabs(StatisticsTab statisticsTab,
                    LanguageTab languageTab,
                    TestResultsTab testResultsTab,
                    AboutTab aboutTab){

        this.add(testResultsTab);
        this.add(statisticsTab);
        this.add(languageTab);
        this.add(aboutTab);

    }

}
