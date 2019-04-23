package edu.kilabs.trv.view.roottab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.resources.ConstantData;
import edu.kilabs.trv.resources.Text;

@SpringComponent
@UIScope
public class AboutTab extends Tab implements RootTabPage {

    // -----------------------------------------------------------------------------------------------------------------

    public AboutTab() {
        setLabel(Text.ABOUT.toString());
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Component getContent() {

        VerticalLayout aboutTabLayout = new VerticalLayout();

        HorizontalLayout authorLine = new HorizontalLayout();
        authorLine.add(new Label(Text.AUTHOR.toString()));
        authorLine.add(new Label(ConstantData.AUTHOR.toString()));

        aboutTabLayout.add(authorLine);
        aboutTabLayout.add(new Label(ConstantData.YEAR.toString()));

        return aboutTabLayout;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
