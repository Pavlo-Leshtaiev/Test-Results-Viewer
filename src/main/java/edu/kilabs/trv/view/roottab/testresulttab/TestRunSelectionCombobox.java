package edu.kilabs.trv.view.roottab.testresulttab;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.resources.Text;
import edu.kilabs.trv.services.TestRunService;

@SpringComponent
@UIScope
public class TestRunSelectionCombobox extends ComboBox<String> {

    // -----------------------------------------------------------------------------------------------------------------

    TestRunSelectionCombobox(TestRunService trs) {

        setLabel(Text.PLEASE_SELECT_TESTRUN.toString());
        setItems(trs.getTestRuns());
        setSizeFull();

    }

    // -----------------------------------------------------------------------------------------------------------------

}
