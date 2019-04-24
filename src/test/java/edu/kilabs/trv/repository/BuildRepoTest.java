package edu.kilabs.trv.repository;

import edu.kilabs.trv.Application;
import edu.kilabs.trv.fixtures.DbHelpers;
import edu.kilabs.trv.model.db.Build;
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

    000 - find build by name

 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class})
@WebAppConfiguration
@Transactional
public class BuildRepoTest {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private BuildRepo buildRepo;

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_findBuildByName(){

        Build build = DbHelpers.generateSampleBuild();
        buildRepo.save(build);

        Optional<Build> retrievedBuild = buildRepo.findByName(build.getName());

        assertTrue("Failed to retrive build", retrievedBuild.isPresent());
        assertEquals("Incorrect build name", build.getName(), retrievedBuild.get().getName());
    }

    // -----------------------------------------------------------------------------------------------------------------

}
