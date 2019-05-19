package edu.trv.view.roottab;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.trv.spring.resources.Text;

import java.util.Locale;

@SpringComponent
@UIScope
public class LanguageTab extends Tab implements RootTabPage {

    // -----------------------------------------------------------------------------------------------------------------

    public static final String ID = "_languageTab";

    // -----------------------------------------------------------------------------------------------------------------

    public LanguageTab() {
        this.setLabel(Text.LANGUAGE.toString());
        Icon questionMark = new Icon(VaadinIcon.WRENCH);
        add(questionMark);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public Component getContent() {
        var topLayout = new VerticalLayout();
        topLayout.setId(ID);

        addLanguageButton(topLayout, Text.LANG_ENG, "en", "US");
        addLanguageButton(topLayout, Text.LANG_GER, "de", "DE");
        addLanguageButton(topLayout, Text.LANG_RUS, "ru", "RU");

        return topLayout;
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void addLanguageButton(VerticalLayout topLayout, Text buttonText, String language, String country) {
        Button btn = new Button(buttonText.toString());
        btn.addClickListener((ev) -> {
            Locale.setDefault(new Locale(language, country));
            Text.refresh();
            UI.getCurrent().getPage().reload();
        });
        topLayout.add(btn);
    }

    // -----------------------------------------------------------------------------------------------------------------

    @Override
    public TabIndex getIndex() {
        return TabIndex.LANGUAGE;
    }

    // -----------------------------------------------------------------------------------------------------------------

}
