package edu.kilabs.trv.view.roottab;

import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.UIScope;
import edu.kilabs.trv.resources.Text;
import org.springframework.stereotype.Component;

@Component
@UIScope
public class AboutTab extends Tab {

    public AboutTab() {
        this.setLabel(Text.ABOUT.toString());
    }
}
