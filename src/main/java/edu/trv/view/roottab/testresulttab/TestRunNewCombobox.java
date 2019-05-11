package edu.trv.view.roottab.testresulttab;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.trv.model.backend.TestRunNameWithId;
import edu.trv.spring.resources.Text;
import edu.trv.spring.services.TestRunService;

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
