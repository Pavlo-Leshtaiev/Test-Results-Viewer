package edu.trv.spring.repository;

import edu.trv.Application;
import edu.trv.fixtures.DbHelpers;
import edu.trv.model.db.TestRun;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/*

    000 - insert data test
    001 - read data test, empty test run
    002 - read data test, test run with test results

 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
@Transactional
public class TestRunRepoTest {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private TestRunRepo repo;

    @Autowired
    private BuildRepo buildRepo;

    @Autowired
    private TestRepo testRepo;

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_insertDataTest(){

        long initialCount = repo.count();

        TestRun testRun = DbHelpers.generateSampleTestRun();
        buildRepo.save(testRun.getBuild());
        repo.save(testRun);

        long acutalCount = repo.count();
        assertEquals("Failed to insert element", initialCount + 1, acutalCount);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T001_readDataTest(){

        TestRun testRun = DbHelpers.generateSampleTestRun();
        buildRepo.save(testRun.getBuild());
        repo.save(testRun);

        Optional<TestRun> retrievedTestRun = repo.findById(testRun.getId());
        assertTrue("Failed to read test run", retrievedTestRun.isPresent());
        assertEquals("Failed to restore elements from DB", testRun, retrievedTestRun.get());

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T002_readDataTestWithTestResults(){

        TestRun testRun = DbHelpers.generateSampleTestRunWithTestResults();
        buildRepo.save(testRun.getBuild());
        testRun.getTestResults().forEach(r -> testRepo.save(r.getTest()));

        repo.save(testRun);

        Optional<TestRun> retrievedTestRun = repo.findById(testRun.getId());
        assertTrue("Failed to read test run", retrievedTestRun.isPresent());
        assertEquals("Failed to restore elements from DB", testRun, retrievedTestRun.get());

    }

    // -----------------------------------------------------------------------------------------------------------------

}
