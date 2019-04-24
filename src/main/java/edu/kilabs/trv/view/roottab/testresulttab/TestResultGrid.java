package edu.kilabs.trv.view.roottab.testresulttab;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.model.db.TestResult;
import edu.kilabs.trv.resources.Text;
import edu.kilabs.trv.services.TestResultService;

import java.util.List;

@SpringComponent
@UIScope
public class TestResultGrid extends Grid<TestResult> {

    // -----------------------------------------------------------------------------------------------------------------

    private final TestResultService trs;

    // -----------------------------------------------------------------------------------------------------------------

    public TestResultGrid(TestResultService trs) {
        this.trs = trs;
        addColumn(tr -> tr.getTest().getTestName()).setHeader(Text.NAME_COLUMN.toString());
        addColumn(TestResult::getResult).setHeader(Text.RESULT_COLUMN.toString());
        addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void showRowsForId(long id){
        List<TestResult> testResultsForId = trs.getTestResultsForId(id);
        if (testResultsForId.size() == 0) {
            throw new RuntimeException("Empty list of values for id: " + String.valueOf(id));
        }
        setItems(testResultsForId);
    }

    // -----------------------------------------------------------------------------------------------------------------

}
