package edu.trv.view.roottab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.trv.spring.resources.ConstantData;
import edu.trv.spring.resources.Text;

@SpringComponent
@UIScope
public class AboutTab extends Tab implements RootTabPage {

    // -----------------------------------------------------------------------------------------------------------------

    public static String ID = "_aboutTab";
    public static final String AUTHOR_LABEL_ID = "_authorLabel";
    public static final String AUTHOR_NAME_ID = "_authorName";
    public static final String COPYRIGHT_ID = "_copyright";

    // -----------------------------------------------------------------------------------------------------------------

    public AboutTab() {
        setLabel(Text.ABOUT.toString());
        Icon questionMark = new Icon(VaadinIcon.QUESTION);
        add(questionMark);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Component getContent() {

        VerticalLayout aboutTabLayout = new VerticalLayout();
        aboutTabLayout.setId(ID);

        HorizontalLayout authorLine = new HorizontalLayout();
        var label = new Label(Text.AUTHOR.toString());
        label.setId(AUTHOR_LABEL_ID);
        authorLine.add(label);

        label = new Label(ConstantData.AUTHOR.toString());
        label.setId(AUTHOR_NAME_ID);
        authorLine.add(label);

        aboutTabLayout.add(authorLine);

        label = new Label(ConstantData.YEAR.toString());
        label.setId(COPYRIGHT_ID);
        aboutTabLayout.add(label);

        return aboutTabLayout;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public TabIndex getIndex() {
        return TabIndex.ABOUT;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
