package edu.kilabs.trv.view.roottab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.resources.Text;

import java.util.Locale;

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
        var topLayout = new VerticalLayout();

        var btn = new Button(Text.LANG_ENG.toString());
        btn.addClickListener((ev) -> {
            Locale.setDefault(new Locale("en", "US"));
            Text.refresh();
            UI.getCurrent().getPage().reload();
        });
        topLayout.add(btn);

        btn = new Button(Text.LANG_GER.toString());
        btn.addClickListener((ev) -> {
            Locale.setDefault(new Locale("de", "DE"));
            Text.refresh();
            UI.getCurrent().getPage().reload();
        });
        topLayout.add(btn);

        return topLayout;
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public TabIndex getIndex() {
        return TabIndex.LANGUAGE;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
