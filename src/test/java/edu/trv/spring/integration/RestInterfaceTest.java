package edu.trv.spring.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.trv.fixtures.DbHelpers;
import edu.trv.fixtures.RestHelpers;
import edu.trv.model.db.TestRun;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/*

    000 - read/write test run

 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class RestInterfaceTest {

    // -----------------------------------------------------------------------------------------------------------------

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ObjectMapper jacksonObjectMapper;

    // -----------------------------------------------------------------------------------------------------------------

    @Test
    public void T000_readWriteTestRun() throws IOException {

        // Prepare test data
        TestRun testRun = DbHelpers.generateSampleTestRunWithTestResults();
        testRun = jacksonObjectMapper.readValue(jacksonObjectMapper.writeValueAsString(testRun), TestRun.class);

        restTemplate.postForEntity(RestHelpers.toLocalRestUrl(port) + RestHelpers.TESTRUN, testRun, TestRun.class);

        // Method under test
        ResponseEntity<List<TestRun>> result = restTemplate.exchange(
                RestHelpers.toLocalRestUrl(port) + RestHelpers.TESTRUNS
                , HttpMethod.GET
                , null
                , new ParameterizedTypeReference<List<TestRun>>() {}
        );

        // Verify results
        assertNotNull("Body shouldn't be null", result.getBody());
        assertEquals("Only one test run should be in result", 1, result.getBody().size());
        assertEquals("Test run contents are not correct", testRun, result.getBody().get(0));

    }

    // -----------------------------------------------------------------------------------------------------------------

}