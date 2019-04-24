package edu.kilabs.trv.services;

import edu.kilabs.trv.Application;
import edu.kilabs.trv.fixtures.DbHelpers;
import edu.kilabs.trv.model.db.TestResult;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/*

    000 - Test results for ID

 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
@Transactional
public class TestResultServiceTest {

    // -----------------------------------------------------------------------------------------------------------------
    
    @Autowired
    TestResultService testResultService;

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

        List<TestResult> testResultsForId = testResultService.getTestResultsForId(testRun.getId());

        assertEquals("Incorrect number of elements.", testRun.getTestResults().size(), testResultsForId.size());
        assertEquals("Incorrect elements returned", testRun.getTestResults(), testResultsForId);

    }

    // -----------------------------------------------------------------------------------------------------------------
}
