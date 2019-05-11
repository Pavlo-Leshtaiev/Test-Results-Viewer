package edu.trv.spring.services.testresult;

import edu.trv.model.backend.ComparisonResult;
import edu.trv.model.db.TestResult;
import edu.trv.model.db.TestRun;
import edu.trv.spring.repository.TestResultRepo;
import edu.trv.spring.repository.TestRunRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TestResultService {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private TestRunRepo repo;

    @Autowired
    private TestResultRepo testResultRepo;

    @Autowired
    private ComparisonResultFactory comparisonResultFactory;

    // -----------------------------------------------------------------------------------------------------------------

    public List<ComparisonResult> getTestResultsForId(long id){
        Optional<TestRun> testRun = repo.findById(id);
        return testRun.map(testRun1 -> testRun1
                    .getTestResults()
                    .stream()
                    .map(comparisonResultFactory::toComparisonResult)
                    .collect(Collectors.toList()))
                .orElseGet(LinkedList::new);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public List<ComparisonResult> getTestComparisonResultsForIds(long oldRunId, long newRunId) {

        TestRun oldTestRun = repo.findById(oldRunId).orElseGet(TestRun::new);
        TestRun newTestRun = repo.findById(newRunId).orElseGet(TestRun::new);

        Map<Long, TestResult> oldResultsByTestId = oldTestRun.getTestResults().stream().collect(Collectors.toMap(
                tr -> tr.getTest().getId(), tr -> tr));

        Map<Long, TestResult> newResultsByTestId = newTestRun.getTestResults().stream().collect(Collectors.toMap(
                tr -> tr.getTest().getId(), tr -> tr));

        return Stream.of(oldResultsByTestId, newResultsByTestId)
                .flatMap(results -> results.keySet().stream())
                .distinct()
                .sorted()
                .map(testId -> comparisonResultFactory.compare(
                          oldResultsByTestId.get(testId)
                        , newResultsByTestId.get(testId))
                )
                .collect(Collectors.toList());

    }

    // -----------------------------------------------------------------------------------------------------------------

}
