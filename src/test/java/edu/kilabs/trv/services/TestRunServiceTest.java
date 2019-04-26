package edu.kilabs.trv.services;

import edu.kilabs.trv.Application;
import edu.kilabs.trv.fixtures.DbHelpers;
import edu.kilabs.trv.model.backend.TestRunNameWithId;
import edu.kilabs.trv.model.db.TestResultOutcome;
import edu.kilabs.trv.model.db.TestRun;
import edu.kilabs.trv.repository.BuildRepo;
import edu.kilabs.trv.repository.TestRunRepo;
import edu.kilabs.trv.resources.Text;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*

    000 - Get run names: empty list test
    001 - Get run names: single test run test


    020 - Persist single run
    021 - Persist multiple runs
    022 - Persist demo data

 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
public class TestRunServiceTest {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private TestRunService trs;

    @Autowired
    private TestRunRepo repo;

    @Autowired
    @Qualifier("dateTimeFormatterFactory")
    private Supplier<DateTimeFormatter> dateTimeFormatterFactory;

    @Autowired
    private BuildRepo buildRepo;

    @Autowired
    @Qualifier("demoData")
    private CommandLineRunner demoData;

    // -----------------------------------------------------------------------------------------------------------------

    @Before
    public void setup(){
        repo.deleteAll();
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_emptyList(){

        List<TestRunNameWithId> testRuns = trs.getTestRunNames();
        assertTrue("Empty list of test runs should be returned.", testRuns.isEmpty());

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T001_singleTestRunTest(){

        TestRun run = DbHelpers.generateSampleTestRun();
        trs.persist(run);

        String expectedResult = MessageFormat.format(Text.MSG_TEST_RUN_NAME.toString(),
                run.getBuild().getName(),
                dateTimeFormatterFactory.get().format(run.getStartTime()));

        List<TestRunNameWithId> testRuns = trs.getTestRunNames();
        assertEquals("One element is expected in the list.", 1, testRuns.size());
        assertEquals("Incorrect message", expectedResult, testRuns.get(0).getName());
        assertEquals("Incorrect message", (long) run.getId(), testRuns.get(0).getId());

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T020_persistSingleTestRun(){

        // Test setup
        TestRun run = DbHelpers.generateSampleTestRunWithTestResults();

        // Methods under test
        trs.persist(run);

        // Verify result
        Optional<TestRun> regeneratedRun = repo.findById(run.getId());
        assertTrue("Failed to retriev test run from repo.", regeneratedRun.isPresent());
        assertEquals("Runs are not equal", run, regeneratedRun.get());

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T021_persistMultipleTestRuns(){

        // Test setup
        TestRun run = DbHelpers.generateSampleTestRunWithTestResults();
        TestRun run2 = DbHelpers.generateSampleTestRunWithTestResults();

        run.getTestResults().get(0).setResult(TestResultOutcome.FAIL);
        run2.getTestResults().get(1).setResult(TestResultOutcome.FAIL);

        // Methods under test
        trs.persist(run);
        trs.persist(run2);

        // Verify result
        Optional<TestRun> regeneratedRun = repo.findById(run.getId());
        Optional<TestRun> regeneratedRun2 = repo.findById(run2.getId());
        assertTrue("Failed to retriev test run from repo.", regeneratedRun.isPresent());
        assertEquals("Runs are not equal", run, regeneratedRun.get());

        assertTrue("Failed to retriev test run from repo.", regeneratedRun2.isPresent());
        assertEquals("Runs are not equal", run2, regeneratedRun2.get());

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T022_persistDemoData() throws Exception {

        // Method under test
        demoData.run((String[]) null);

        // Verify result
    }

    // -----------------------------------------------------------------------------------------------------------------

}
