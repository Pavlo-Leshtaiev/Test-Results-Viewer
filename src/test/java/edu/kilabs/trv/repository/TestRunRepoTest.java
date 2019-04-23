package edu.kilabs.trv.repository;

import edu.kilabs.trv.Application;
import edu.kilabs.trv.model.TestRun;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/*

    000 - insert data test;

 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
public class TestRunRepoTest {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private TestRunRepo repo;

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_insertDataTest(){

        long initialCount = repo.count();

        repo.save(new TestRun());

        long acutalCount = repo.count();
        assertEquals("Failed to insert element", initialCount + 1, acutalCount);
    }

    // -----------------------------------------------------------------------------------------------------------------

}
