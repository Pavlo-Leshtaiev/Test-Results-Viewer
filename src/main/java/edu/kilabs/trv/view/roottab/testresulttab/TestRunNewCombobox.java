package edu.kilabs.trv.view.roottab.testresulttab;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.model.backend.TestRunNameWithId;
import edu.kilabs.trv.resources.Text;
import edu.kilabs.trv.services.TestRunService;

@SpringComponent
@UIScope
public class TestRunNewCombobox extends ComboBox<TestRunNameWithId> {

    // -----------------------------------------------------------------------------------------------------------------

    private TestRunOldCombobox oldCombobox;

    // -----------------------------------------------------------------------------------------------------------------

    TestRunNewCombobox(TestRunService trs, TestResultGrid grid) {

        setLabel(Text.COMPARE_WITH_RUN.toString());
        setItems(trs.getTestRunNames());
        setItemLabelGenerator(TestRunNameWithId::getName);
        setSizeFull();

        addValueChangeListener(event -> {
            if (event.getSource().isEmpty()) {
                grid.setItems();
            } else {
                grid.toComparisonMode();
                grid.showComparisonForIds(oldCombobox.getValue().getId(), event.getValue().getId());
            }
        });

    }

    // -----------------------------------------------------------------------------------------------------------------

    public void setOldCombobox(TestRunOldCombobox oldCombobox) {
        this.oldCombobox = oldCombobox;
    }

    // -----------------------------------------------------------------------------------------------------------------
}
