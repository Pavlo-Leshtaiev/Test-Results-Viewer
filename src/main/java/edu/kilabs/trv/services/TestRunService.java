package edu.kilabs.trv.services;

import com.vaadin.flow.spring.annotation.SpringComponent;
import edu.kilabs.trv.model.TestRun;
import edu.kilabs.trv.repository.TestRunRepo;
import edu.kilabs.trv.resources.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringComponent
public class TestRunService {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private TestRunRepo repo;

    @Autowired
    @Qualifier("dateTimeFormatterFactory")
    private Supplier<DateTimeFormatter> dateTimeFormatterFactory;

    // -----------------------------------------------------------------------------------------------------------------

    public List<String> getTestRuns(){

        return repo.findAll()
                   .stream()
                   .map(this::runToString)
                   .collect(Collectors.toList());

    }

    // -----------------------------------------------------------------------------------------------------------------

    private String runToString(TestRun testRun) {

        return MessageFormat.format(Text.MSG_TEST_RUN_NAME.toString(),
                testRun.getBuild().getName(),
                dateTimeFormatterFactory.get().format(testRun.getStartTime()));

    }

    // -----------------------------------------------------------------------------------------------------------------

}
