package edu.kilabs.trv.services;

import edu.kilabs.trv.Application;
import edu.kilabs.trv.fixtures.DbHelpers;
import edu.kilabs.trv.model.TestRun;
import edu.kilabs.trv.repository.BuildRepo;
import edu.kilabs.trv.repository.TestRunRepo;
import edu.kilabs.trv.resources.Text;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*

    000 - empty list test
    001 - single test run test

 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
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

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_emptyList(){

        List<String> testRuns = trs.getTestRuns();
        assertTrue("Empty list of test runs should be returned.", testRuns.isEmpty());

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T001_singleTestRunTest(){

        TestRun run = DbHelpers.generateSampleTestRun();
        buildRepo.save(run.getBuild());
        repo.save(run);

        String expectedResult = MessageFormat.format(Text.MSG_TEST_RUN_NAME.toString(),
                run.getBuild().getName(),
                dateTimeFormatterFactory.get().format(run.getStartTime()));

        List<String> testRuns = trs.getTestRuns();
        assertEquals("One element is expected in the list.", 1, testRuns.size());
        assertEquals("Incorrect message", expectedResult, testRuns.get(0));

    }

    // -----------------------------------------------------------------------------------------------------------------

}
