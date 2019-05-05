package edu.kilabs.trv.rest;

import edu.kilabs.trv.fixtures.DbHelpers;
import edu.kilabs.trv.fixtures.RestHelpers;
import edu.kilabs.trv.helpers.HelpersConfiguration;
import edu.kilabs.trv.model.db.TestRun;
import edu.kilabs.trv.repository.TestRunRepo;
import edu.kilabs.trv.rest.adapters.TestRunAdapter;
import edu.kilabs.trv.rest.controllers.TestRunRestController;
import edu.kilabs.trv.services.TestRunService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*

    000 - get all test runs, single test run
    001 - get all test runs, no test runs

 */

@ExtendWith(SpringExtension.class)
@WebMvcTest({TestRunRestController.class, HelpersConfiguration.class})
public class TestRunRestControllerMockTest {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TestRunService service;

    @MockBean
    private TestRunRepo repo;

    @MockBean
    private TestRunAdapter adapter;

    @Autowired
    private Supplier<DateTimeFormatter> dateTimeFormatterFactory;

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_getAllTestRuns() throws Exception {

        // Prepare test data
        TestRun testRun = DbHelpers.generateSampleTestRunWithTestResults();
        List<TestRun> testRuns = new LinkedList<>();
        testRuns.add(testRun);
        DateTimeFormatter dateTimeFormatter = dateTimeFormatterFactory.get();

        when(repo.findAll()).thenReturn(testRuns);

        // Method under test
        mockMvc.perform(get(RestHelpers.TESTRUNS))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$.[0].build.name").value(testRun.getBuild().getName()))
                .andExpect(jsonPath("$.[0].startTime")
                        .value(dateTimeFormatter.format(testRun.getStartTime())))
                .andExpect(jsonPath("$.[0].testResults[0].test.testName")
                        .value(testRun.getTestResults().get(0).getTest().getTestName()))
                .andExpect(jsonPath("$.[0].testResults[1].test.testName")
                        .value(testRun.getTestResults().get(1).getTest().getTestName()));

    }

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T001_getAllTestRunsNoRuns() throws Exception {

        // Prepare Test Data
        when(repo.findAll()).thenReturn(new LinkedList<>());

        // Method under test
        mockMvc.perform(get(RestHelpers.TESTRUNS))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0));

    }

    // -----------------------------------------------------------------------------------------------------------------

}