package edu.kilabs.trv.helpers;

import edu.kilabs.trv.model.*;
import edu.kilabs.trv.repository.BuildRepo;
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
    public CommandLineRunner demoData(TestRunRepo testRunRepo, BuildRepo buildRepo) {

        Test testA = new Test("Test A.");
        Test testB = new Test("Test B.");
        Test testC = new Test("Test C.");

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

        return args -> {
            buildRepo.save(testBuild);

            testRunRepo.save(sampleTestRun);
            testRunRepo.save(sampleTestRun2);
        };

    }

    // -----------------------------------------------------------------------------------------------------------------
}
