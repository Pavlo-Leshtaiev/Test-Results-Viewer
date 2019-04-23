package edu.kilabs.trv.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import edu.kilabs.trv.model.TestRun;
import edu.kilabs.trv.repository.TestRunRepo;
import edu.kilabs.trv.view.roottab.RootTabs;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class TopLevelView extends VerticalLayout {

    // -----------------------------------------------------------------------------------------------------------------

    @Autowired
    private TestRunRepo repo;

    // -----------------------------------------------------------------------------------------------------------------

    public TopLevelView(RootTabs rootTabs) {

        add(rootTabs);
        add(rootTabs.getContents());

    }

    // -----------------------------------------------------------------------------------------------------------------

    private void onButtonClick(ClickEvent<Button> ev) {
        repo.save(new TestRun());
        Notification.show(String.format("Main menu! Number of elements: %d", repo.count()));
    }

    // -----------------------------------------------------------------------------------------------------------------

}
