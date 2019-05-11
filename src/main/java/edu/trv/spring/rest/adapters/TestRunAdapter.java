package edu.trv.spring.rest.adapters;

import edu.trv.model.db.TestRun;
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
