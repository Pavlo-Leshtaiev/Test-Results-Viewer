package edu.kilabs.trv.services;

import edu.kilabs.trv.model.backend.TestRunNameWithId;
import edu.kilabs.trv.model.db.TestRun;
import edu.kilabs.trv.repository.TestRunRepo;
import edu.kilabs.trv.resources.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
@Transactional
public class TestRunService {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private TestRunRepo repo;

    @Autowired
    @Qualifier("dateTimeFormatterFactory")
    private Supplier<DateTimeFormatter> dateTimeFormatterFactory;

    // -----------------------------------------------------------------------------------------------------------------

    public List<TestRunNameWithId> getTestRuns(){

        return repo.findAll()
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

}
