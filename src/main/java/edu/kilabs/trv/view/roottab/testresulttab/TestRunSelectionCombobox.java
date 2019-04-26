package edu.kilabs.trv.view.roottab.testresulttab;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.model.backend.TestRunNameWithId;
import edu.kilabs.trv.resources.Text;
import edu.kilabs.trv.services.TestRunService;

@SpringComponent
@UIScope
public class TestRunSelectionCombobox extends ComboBox<TestRunNameWithId> {

    // -----------------------------------------------------------------------------------------------------------------

    TestRunSelectionCombobox(TestRunService trs, TestResultGrid grid) {

        setLabel(Text.PLEASE_SELECT_TESTRUN.toString());
        setItems(trs.getTestRunNames());
        setItemLabelGenerator(TestRunNameWithId::getName);
        setSizeFull();

        addValueChangeListener(event -> {
            if (event.getSource().isEmpty()) {
                // message.setText("No browser selected");
            } else {
                grid.showRowsForId(event.getValue().getId());
            }
        });

    }

    // -----------------------------------------------------------------------------------------------------------------

}
