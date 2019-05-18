package edu.trv.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import edu.trv.view.roottab.RootTabs;

@Route("")
public class TopLevelView extends VerticalLayout {

    // -----------------------------------------------------------------------------------------------------------------

    public TopLevelView(RootTabs rootTabs) {

        add(rootTabs);
        add(rootTabs.getContents());

    }

    // -----------------------------------------------------------------------------------------------------------------

}
