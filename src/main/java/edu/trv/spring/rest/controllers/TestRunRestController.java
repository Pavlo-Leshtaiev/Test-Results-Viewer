package edu.trv.spring.rest.controllers;

import edu.trv.model.db.TestRun;
import edu.trv.spring.repository.TestRunRepo;
import edu.trv.spring.rest.adapters.TestRunAdapter;
import edu.trv.spring.services.TestRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rest")
public class TestRunRestController {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private TestRunRepo repo;

    @Autowired
    private TestRunService trs;

    @Autowired
    private TestRunAdapter adapter;

    // -----------------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/testruns", method = RequestMethod.GET)
    public List<TestRun> getAllTestRuns() {
        return repo.findAll();
    }

    // -----------------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/testrun/{$id}", method = RequestMethod.DELETE)
    public void deleteTestRunById(@PathVariable("$id") Long testRunId) {
        repo.deleteById(testRunId);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @RequestMapping(value = "/testrun", method = RequestMethod.POST)
    public void addTestRun(@RequestBody TestRun testRun) {
        trs.persist(adapter.toInternal(testRun));
    }

    // -----------------------------------------------------------------------------------------------------------------

}
