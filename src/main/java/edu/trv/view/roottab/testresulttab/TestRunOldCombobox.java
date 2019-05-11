package edu.trv.view.roottab.testresulttab;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.trv.model.backend.TestRunNameWithId;
import edu.trv.spring.resources.Text;
import edu.trv.spring.services.TestRunService;

@SpringComponent
@UIScope
public class TestRunOldCombobox extends ComboBox<TestRunNameWithId> {

    // -----------------------------------------------------------------------------------------------------------------

    private TestRunNewCombobox newCombobox;

    // -----------------------------------------------------------------------------------------------------------------

    TestRunOldCombobox(TestRunService trs, TestResultGrid grid) {

        setLabel(Text.PLEASE_SELECT_TESTRUN.toString());
        setItems(trs.getTestRunNames());
        setItemLabelGenerator(TestRunNameWithId::getName);
        setSizeFull();

        addValueChangeListener(event -> {
            newCombobox.setValue(null);
            grid.toSingleMode();
            if (event.getSource().isEmpty()) {
                grid.setItems();
                newCombobox.setVisible(false);
            } else {
                grid.showRowsForId(event.getValue().getId());
                newCombobox.setVisible(true);
            }
        });

    }

    // -----------------------------------------------------------------------------------------------------------------

    public void setNewCombobox(TestRunNewCombobox newCombobox) {
        this.newCombobox = newCombobox;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
