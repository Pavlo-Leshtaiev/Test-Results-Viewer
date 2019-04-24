package edu.kilabs.trv.services;

import edu.kilabs.trv.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;

/*

    000 - read write data test

 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class)
@WebAppConfiguration
public class StatePersistenceServiceTest {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private StatePersistenceService sps;

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_readWriteData(){

        final String TEST_KEY = "test_key";
        final int TEST_DATA = 7;

        sps.saveInt(TEST_KEY, TEST_DATA);
        assertEquals("Failed to retreive data from sps service.", TEST_DATA, sps.getInt(TEST_KEY));

    }

    // -----------------------------------------------------------------------------------------------------------------

}
