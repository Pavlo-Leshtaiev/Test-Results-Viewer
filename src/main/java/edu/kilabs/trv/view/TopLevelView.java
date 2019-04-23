package edu.kilabs.trv.view;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.treegrid.TreeGrid;
import com.vaadin.flow.router.Route;
import edu.kilabs.trv.model.TestRun;
import edu.kilabs.trv.repository.TestRunRepo;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class TopLevelView extends VerticalLayout {

    @Autowired
    private TestRunRepo repo;

    public TopLevelView() {

        // Header layout
        HorizontalLayout headerLayout = new HorizontalLayout();
        headerLayout.setVerticalComponentAlignment(Alignment.CENTER);
        add(headerLayout);
        headerLayout.add(new Label("Notification:"));
        headerLayout.add(new Button("Button with text", this::onButtonClick));

        // Main body layout
        HorizontalLayout mainBodyLayout = new HorizontalLayout();
        TreeGrid<TestRun> grid = new TreeGrid<>();
        mainBodyLayout.add(grid);
        add(mainBodyLayout);
    }

    private void onButtonClick(ClickEvent<Button> ev) {
        repo.save(new TestRun());
        Notification.show(String.format("Main menu! Number of elements: %d", repo.count()));
    }
}
