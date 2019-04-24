package edu.kilabs.trv.services;

import edu.kilabs.trv.Application;
import edu.kilabs.trv.fixtures.DbHelpers;
import edu.kilabs.trv.model.backend.Statistics;
import edu.kilabs.trv.model.db.TestRun;
import edu.kilabs.trv.repository.BuildRepo;
import edu.kilabs.trv.repository.TestRepo;
import edu.kilabs.trv.repository.TestRunRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/*

    000 - statistics for single test run

 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
public class StatisticsServiceTest {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    StatisticsService statisticsService;

    @Autowired
    BuildRepo buildRepo;

    @Autowired
    TestRunRepo testRunRepo;

    @Autowired
    TestRepo testRepo;

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_testResultsForId(){

        TestRun testRun = DbHelpers.generateSampleTestRunWithTestResults();
        buildRepo.save(testRun.getBuild());
        testRun.getTestResults().forEach(r -> testRepo.save(r.getTest()));
        testRunRepo.save(testRun);

        Statistics statistics = statisticsService.getStatistics();

        assertEquals("Incorrect number of failed tests.", 0, statistics.getNumFailedTests());
        assertEquals("Incorrect number of pass tests.", 2, statistics.getNumPassTests());
        assertEquals("Incorrect number of tests.", 2, statistics.getNumTests());
        assertEquals("Incorrect number of test results.", 2, statistics.getNumTestResults());
        assertEquals("Incorrect pass rate.", 100, statistics.getAveragePassRate());

    }

    // -----------------------------------------------------------------------------------------------------------------

}
