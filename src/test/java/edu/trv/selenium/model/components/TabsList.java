package edu.trv.selenium.model.components;

import edu.trv.selenium.model.base.Locator;
import edu.trv.selenium.model.base.SeleniumBaseComponent;
import edu.trv.selenium.resources.WebComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;

public class TabsList extends SeleniumBaseComponent {

    // -----------------------------------------------------------------------------------------------------------------

    private final List<Class<? extends Tab>> classes;
    private List<Tab> tabs;

    // -----------------------------------------------------------------------------------------------------------------

    public TabsList(By locator, List<Class<? extends Tab>> classes) {
        super(locator);
        this.classes = classes;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public List<Tab> getTabs() {

        if (tabs == null) {
            List<WebElement> elements = getWebElement().findElements(By.tagName(WebComponents.VAADIN_TAB.toString()));

            tabs = new LinkedList<>();
            for (int i = 1; i <= elements.size(); i++) {
                tabs.add(Tab.of(getTabLocatorByIndex(i)));
            }
        }
        return tabs;
    }

    // -----------------------------------------------------------------------------------------------------------------

    protected <T extends Tab> T selectTabByClass(Class<T> tabContentClass) {

        int tabPosition = getTabPosition(tabContentClass);
        Constructor<T> constructor = getConstructor(tabContentClass);
        var tab = instantiate(tabContentClass, tabPosition, constructor);
        tab.click();
        return tab;

    }

    // -----------------------------------------------------------------------------------------------------------------

    private <T extends Tab> int getTabPosition(Class<T> tabContentClass) {
        int classIndex = classes.indexOf(tabContentClass);
        if (classIndex == -1) {
            throw new IllegalArgumentException(
                    MessageFormat.format(
                            "The ''{0}'' class was not found in the ''{1}'' list.", tabContentClass, classes));
        }
        // In xpath expression indexation starts from 1
        return classIndex + 1;
    }

    // -----------------------------------------------------------------------------------------------------------------

    private <T extends Tab> Constructor<T> getConstructor(Class<T> tabContentClass) {
        Constructor<T> constructor;
        try {
            constructor = tabContentClass.getConstructor(Locator.class);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException(
                    MessageFormat.format(
                            "The ''{0}'' class doesn't have constructor which accepts single locator argument", tabContentClass
                    )
                    , e
            );
        }
        return constructor;
    }

    // -----------------------------------------------------------------------------------------------------------------

    private <T extends Tab> T instantiate(Class<T> tabContentClass, int classIndex, Constructor<T> constructor) {
        T tab = null;
        try {
            tab = constructor.newInstance(getTabLocatorByIndex(classIndex));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException(
                    MessageFormat.format(
                            "Failed to instantiate ''{0}'' class.", tabContentClass
                    )
                    , e
            );
        }
        return tab;
    }

    // -----------------------------------------------------------------------------------------------------------------

    private Locator getTabLocatorByIndex(int index) {
        return getLocator().ofChild(By.xpath(MessageFormat.format(
                ".//{0}[{1}]", WebComponents.VAADIN_TAB, index)));
    }

    // -----------------------------------------------------------------------------------------------------------------

}

