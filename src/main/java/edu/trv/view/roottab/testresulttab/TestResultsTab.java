package edu.trv.view.roottab.testresulttab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.trv.spring.resources.Text;
import edu.trv.view.roottab.RootTabPage;
import edu.trv.view.roottab.TabIndex;

@SpringComponent
@UIScope
public class TestResultsTab extends Tab implements RootTabPage {

    // -----------------------------------------------------------------------------------------------------------------

    private final TestRunNewCombobox testRunNewCombobox;
    private final TestRunOldCombobox testRunOldCombobox;
    private final TestResultGrid grid;

    // -----------------------------------------------------------------------------------------------------------------

    public TestResultsTab(
              TestRunOldCombobox testRunOldCombobox
            , TestRunNewCombobox testRunNewCombobox
            , TestResultGrid grid) {

        this.testRunOldCombobox = testRunOldCombobox;
        testRunOldCombobox.setNewCombobox(testRunNewCombobox);

        this.testRunNewCombobox = testRunNewCombobox;
        testRunNewCombobox.setOldCombobox(testRunOldCombobox);
        testRunNewCombobox.setVisible(false);
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

        HorizontalLayout testRunSelection = new HorizontalLayout();
        testRunSelection.setSizeFull();
        testRunSelection.add(testRunOldCombobox);
        testRunSelection.add(testRunNewCombobox);
        result.add(testRunSelection);

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
