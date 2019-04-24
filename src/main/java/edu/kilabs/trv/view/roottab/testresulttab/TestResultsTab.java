package edu.kilabs.trv.view.roottab.testresulttab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.resources.Text;
import edu.kilabs.trv.view.roottab.RootTabPage;
import edu.kilabs.trv.view.roottab.TabIndex;

@SpringComponent
@UIScope
public class TestResultsTab extends Tab implements RootTabPage {

    // -----------------------------------------------------------------------------------------------------------------

    private final TestRunSelectionCombobox combobox;

    // -----------------------------------------------------------------------------------------------------------------

    public TestResultsTab(TestRunSelectionCombobox combobox) {

        this.combobox = combobox;

        this.setLabel(Text.TEST_RESULTS.toString());

        Icon questionMark = new Icon(VaadinIcon.GRID);
        add(questionMark);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Component getContent() {

        var result = new VerticalLayout();
        result.setSizeFull();
        result.add(combobox);

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public TabIndex getIndex() {
        return TabIndex.TEST_RESULTS;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
