package edu.kilabs.trv.view.roottab;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.resources.Text;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class TestResultsTab extends Tab {

    public TestResultsTab() {
        this.setLabel(Text.TEST_RESULTS.toString());
    }

}
