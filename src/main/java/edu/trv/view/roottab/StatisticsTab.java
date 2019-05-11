package edu.trv.view.roottab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.trv.model.backend.Statistics;
import edu.trv.spring.resources.Text;
import edu.trv.spring.services.StatisticsService;

@SpringComponent
@UIScope
public class StatisticsTab extends Tab implements RootTabPage {

    // -----------------------------------------------------------------------------------------------------------------

    private final StatisticsService statisticsService;

    // -----------------------------------------------------------------------------------------------------------------

    public StatisticsTab(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;

        this.setLabel(Text.STATISTICS.toString());
        Icon questionMark = new Icon(VaadinIcon.PIE_CHART);
        add(questionMark);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Component getContent() {

        Statistics statistics = statisticsService.getStatistics();
        var layout = new VerticalLayout();

        addStatisticsField(Text.NUMBER_OF_TESTS, statistics.getNumTests(), layout);
        addStatisticsField(Text.NUMBER_OF_TEST_RESULTS, statistics.getNumTestResults(), layout);
        addStatisticsField(Text.NUMBER_OF_PASS_TESTS, statistics.getNumPassTests(), layout);
        addStatisticsField(Text.NUMBER_OF_FAIL_TESTS, statistics.getNumFailedTests(), layout);
        addStatisticsField(Text.AVERAGE_PASS_RATE, statistics.getAveragePassRate(), layout);

        return layout;

    }

    // -----------------------------------------------------------------------------------------------------------------

    private void addStatisticsField(Text text, long value, VerticalLayout layout) {
        TextField textField = new TextField(text.toString());
        textField.setValue(String.valueOf(value));
        textField.setReadOnly(true);
        layout.add(textField);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public TabIndex getIndex() {
        return TabIndex.STATISTICS;
    }

    // -----------------------------------------------------------------------------------------------------------------
}
