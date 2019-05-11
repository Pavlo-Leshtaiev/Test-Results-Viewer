package edu.trv.view.roottab.testresulttab;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.trv.model.backend.ComparisonResult;
import edu.trv.spring.resources.Text;
import edu.trv.spring.services.testresult.TestResultService;

import java.util.List;

@SpringComponent
@UIScope
public class TestResultGrid extends Grid<ComparisonResult> {

    // -----------------------------------------------------------------------------------------------------------------

    private final TestResultService trs;
    private boolean isComparisonModeActivated = false;

    // -----------------------------------------------------------------------------------------------------------------

    public TestResultGrid(TestResultService trs) {
        this.trs = trs;
        addColumn(ComparisonResult::getTestName).setHeader(Text.NAME_COLUMN.toString());
        addColumn(ComparisonResult::getOldResult)
                .setKey(Text.RESULT_COLUMN.toString())
                .setHeader(Text.RESULT_COLUMN.toString());
        addThemeVariants(GridVariant.LUMO_ROW_STRIPES);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void showRowsForId(long id){
        List<ComparisonResult> testResultsForId = trs.getTestResultsForId(id);
        setItems(testResultsForId);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void showComparisonForIds(long oldRun, long newRun) {
        List<ComparisonResult> testResultsForId = trs.getTestComparisonResultsForIds(oldRun, newRun);
        setItems(testResultsForId);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void toComparisonMode(){
        if (!isComparisonModeActivated) {
            getColumnByKey(Text.RESULT_COLUMN.toString()).setHeader(Text.OLD_RESULT_COLUMN.toString());
            addColumn(ComparisonResult::getNewResult)
                    .setKey(Text.NEW_RESULT_COLUMN.toString())
                    .setHeader(Text.NEW_RESULT_COLUMN.toString());
            addColumn(ComparisonResult::getTestResultComparisonOutcome)
                    .setKey(Text.COMPARISON_RESULT_COLUMN.toString())
                    .setHeader(Text.COMPARISON_RESULT_COLUMN.toString());
            isComparisonModeActivated = true;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void toSingleMode(){
        if (isComparisonModeActivated) {
            getColumnByKey(Text.RESULT_COLUMN.toString()).setHeader(Text.RESULT_COLUMN.toString());
            removeColumnByKey(Text.NEW_RESULT_COLUMN.toString());
            removeColumnByKey(Text.COMPARISON_RESULT_COLUMN.toString());
            isComparisonModeActivated = false;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

}
