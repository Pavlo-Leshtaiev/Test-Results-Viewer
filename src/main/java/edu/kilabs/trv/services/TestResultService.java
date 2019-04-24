package edu.kilabs.trv.services;

import edu.kilabs.trv.model.db.TestResult;
import edu.kilabs.trv.model.db.TestRun;
import edu.kilabs.trv.repository.TestResultRepo;
import edu.kilabs.trv.repository.TestRunRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class TestResultService {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private TestRunRepo repo;

    @Autowired
    private TestResultRepo testResultRepo;

    // -----------------------------------------------------------------------------------------------------------------

    public List<TestResult> getTestResultsForId(long id){
        Optional<TestRun> testRun = repo.findById(id);
        if (testRun.isPresent()) {
            return testRun.get().getTestResults();
        } else {
            return new LinkedList<>();
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

}
