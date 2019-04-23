package edu.kilabs.trv.view.roottab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.resources.Text;

@SpringComponent
@UIScope
public class LanguageTab extends Tab implements RootTabPage {

    // -----------------------------------------------------------------------------------------------------------------

    public LanguageTab() {
        this.setLabel(Text.LANGUAGE.toString());
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Component getContent() {
        return new VerticalLayout();
    }

    // -----------------------------------------------------------------------------------------------------------------

}
