package edu.trv.spring.services;

import edu.trv.model.backend.TestRunNameWithId;
import edu.trv.model.db.Build;
import edu.trv.model.db.Test;
import edu.trv.model.db.TestResult;
import edu.trv.model.db.TestRun;
import edu.trv.spring.repository.BuildRepo;
import edu.trv.spring.repository.TestRepo;
import edu.trv.spring.repository.TestRunRepo;
import edu.trv.spring.resources.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@Transactional
public class TestRunService {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private TestRunRepo testRunRepo;

    @Autowired
    private BuildRepo buildRepo;

    @Autowired
    private TestRepo testRepo;

    @Autowired
    @Qualifier("dateTimeFormatterFactory")
    private Supplier<DateTimeFormatter> dateTimeFormatterFactory;

    // -----------------------------------------------------------------------------------------------------------------

    public List<TestRunNameWithId> getTestRunNames(){

        return testRunRepo.findAll()
                   .stream()
                   .map(this::runToString)
                   .collect(Collectors.toList());

    }

    // -----------------------------------------------------------------------------------------------------------------

    private TestRunNameWithId runToString(TestRun testRun) {

        String name = MessageFormat.format(Text.MSG_TEST_RUN_NAME.toString(),
                testRun.getBuild().getName(),
                dateTimeFormatterFactory.get().format(testRun.getStartTime()));

        long id = testRun.getId();

        return TestRunNameWithId.of(name, id);

    }

    // -----------------------------------------------------------------------------------------------------------------

    public void persist(TestRun run) {
        Optional<Build> build = buildRepo.findByName(run.getBuild().getName());
        if (build.isEmpty()) {
            buildRepo.save(run.getBuild());
        } else {
            run.setBuild(build.get());
        }

        run.getTestResults().forEach(this::saveTest);

        testRunRepo.save(run);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void saveTest(TestResult testResult) {
        Optional<Test> test = testRepo.findByTestName(testResult.getTest().getTestName());
        if (test.isEmpty()) {
            testRepo.save(testResult.getTest());
        } else {
            testResult.setTest(test.get());
        }

    }

    // -----------------------------------------------------------------------------------------------------------------

}
