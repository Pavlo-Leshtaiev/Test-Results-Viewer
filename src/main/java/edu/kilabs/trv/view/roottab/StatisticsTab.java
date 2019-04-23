package edu.kilabs.trv.view.roottab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.resources.Text;

@SpringComponent
@UIScope
public class StatisticsTab extends Tab implements RootTabPage {

    // -----------------------------------------------------------------------------------------------------------------

    public StatisticsTab() {
        this.setLabel(Text.STATISTICS.toString());
        Icon questionMark = new Icon(VaadinIcon.PIE_CHART);
        add(questionMark);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Component getContent() {
        return new VerticalLayout();
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public TabIndex getIndex() {
        return TabIndex.STATISTICS;
    }

    // -----------------------------------------------------------------------------------------------------------------
}
