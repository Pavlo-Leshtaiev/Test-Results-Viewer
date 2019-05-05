package edu.kilabs.trv.rest.adapters;

import edu.kilabs.trv.model.db.TestRun;
import org.springframework.stereotype.Component;

@Component
public class TestRunAdapter {

    // -----------------------------------------------------------------------------------------------------------------

    public TestRun toInternal(TestRun run) {
        run.getTestResults().forEach(tr -> tr.setTestRun(run));
        return run;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
