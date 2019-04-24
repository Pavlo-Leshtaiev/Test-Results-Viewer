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
    private final TestResultGrid grid;

    // -----------------------------------------------------------------------------------------------------------------

    public TestResultsTab(TestRunSelectionCombobox combobox, TestResultGrid grid) {

        this.combobox = combobox;
        this.grid = grid;

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
        result.add(grid);

        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public TabIndex getIndex() {
        return TabIndex.TEST_RESULTS;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
