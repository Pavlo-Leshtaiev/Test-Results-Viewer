package edu.kilabs.trv.view.roottab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.resources.Text;

@SpringComponent
@UIScope
public class TestResultsTab extends Tab implements RootTabPage {

    // -----------------------------------------------------------------------------------------------------------------

    public TestResultsTab() {
        this.setLabel(Text.TEST_RESULTS.toString());
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Component getContent() {
        return new VerticalLayout();
    }

    // -----------------------------------------------------------------------------------------------------------------

}
