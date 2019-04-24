package edu.kilabs.trv.helpers;

import edu.kilabs.trv.model.db.*;
import edu.kilabs.trv.repository.BuildRepo;
import edu.kilabs.trv.repository.TestRepo;
import edu.kilabs.trv.repository.TestRunRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Configuration
public class SampleDataConfiguration {

    // -----------------------------------------------------------------------------------------------------------------

    @Bean
    public CommandLineRunner demoData(TestRunRepo testRunRepo, BuildRepo buildRepo, TestRepo testRepo) {

        Test testA = new Test("Test A.");
        Test testB = new Test("Test B.");
        Test testC = new Test("Test C.");
        Test testD = new Test("Test D.");
        Test testE = new Test("Test E.");

        Build testBuild = new Build();
        testBuild.setName("Linux_build_001");

        TestRun sampleTestRun = new TestRun();
        sampleTestRun.setBuild(testBuild);
        sampleTestRun.setStartTime(ZonedDateTime.of(2019, 4, 24, 10, 1,1,0, ZoneId.systemDefault()));

        sampleTestRun.addTestResult(TestResult.of(testA, TestResultOutcome.PASS));
        sampleTestRun.addTestResult(TestResult.of(testB, TestResultOutcome.FAIL));
        sampleTestRun.addTestResult(TestResult.of(testC, TestResultOutcome.PASS));

        TestRun sampleTestRun2 = new TestRun();
        sampleTestRun2.setBuild(testBuild);
        sampleTestRun2.setStartTime(ZonedDateTime.of(2019, 4, 23, 9, 54,24,0, ZoneId.systemDefault()));

        sampleTestRun2.addTestResult(TestResult.of(testA, TestResultOutcome.PASS));
        sampleTestRun2.addTestResult(TestResult.of(testB, TestResultOutcome.PASS));
        sampleTestRun2.addTestResult(TestResult.of(testC, TestResultOutcome.FAIL));

        TestRun sampleTestRun3 = new TestRun();
        sampleTestRun3.setBuild(testBuild);
        sampleTestRun3.setStartTime(ZonedDateTime.of(2019, 5, 23, 7, 7,7,0, ZoneId.systemDefault()));

        sampleTestRun3.addTestResult(TestResult.of(testA, TestResultOutcome.PASS));
        sampleTestRun3.addTestResult(TestResult.of(testC, TestResultOutcome.FAIL));
        sampleTestRun3.addTestResult(TestResult.of(testD, TestResultOutcome.PASS));
        sampleTestRun3.addTestResult(TestResult.of(testE, TestResultOutcome.FAIL));

        return args -> {
            buildRepo.save(testBuild);

            testRepo.save(testA);
            testRepo.save(testB);
            testRepo.save(testC);
            testRepo.save(testD);
            testRepo.save(testE);

            testRunRepo.save(sampleTestRun);
            testRunRepo.save(sampleTestRun2);
            testRunRepo.save(sampleTestRun3);
        };

    }

    // -----------------------------------------------------------------------------------------------------------------
}
