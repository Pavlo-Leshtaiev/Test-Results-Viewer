package edu.trv.spring.services;

import edu.trv.model.backend.Statistics;
import edu.trv.model.db.TestResultOutcome;
import edu.trv.spring.repository.TestRepo;
import edu.trv.spring.repository.TestResultRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private TestRepo testRepo;

    @Autowired
    private TestResultRepo testResultRepo;

    // -----------------------------------------------------------------------------------------------------------------

    public Statistics getStatistics() {
        Statistics result = new Statistics();
        result.setNumTests(testRepo.count());
        result.setNumTestResults(testResultRepo.count());
        result.setNumPassTests(testResultRepo.countByResult(TestResultOutcome.PASS));
        result.setNumFailedTests(testResultRepo.countByResult(TestResultOutcome.FAIL));
        result.setAveragePassRate(calculateAveragePassRate(result));
        return result;
    }

    // -----------------------------------------------------------------------------------------------------------------

    private long calculateAveragePassRate(Statistics result) {
        return (result.getNumPassTests()*100)/(result.getNumPassTests() + result.getNumFailedTests());
    }

    // -----------------------------------------------------------------------------------------------------------------
}
