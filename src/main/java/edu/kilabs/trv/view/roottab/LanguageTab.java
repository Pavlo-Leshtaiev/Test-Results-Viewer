package edu.kilabs.trv.view.roottab;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.resources.Text;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class LanguageTab extends Tab {

    public LanguageTab() {
        this.setLabel(Text.LANGUAGE.toString());
    }

}
