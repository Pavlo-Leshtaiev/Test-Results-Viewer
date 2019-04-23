package edu.kilabs.trv.services;

import com.vaadin.flow.spring.annotation.SpringComponent;
import edu.kilabs.trv.view.roottab.TabIndex;

import java.util.HashMap;
import java.util.Map;

@SpringComponent
public class StatePersistenceService {

    // -----------------------------------------------------------------------------------------------------------------

    private final Map<String, Integer> dataStore = new HashMap<>();

    // -----------------------------------------------------------------------------------------------------------------

    void saveInt(String key, int value){
        dataStore.put(key, value);
    }

    // -----------------------------------------------------------------------------------------------------------------

    int getInt(String key){
        return dataStore.get(key);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void save(SdsKeys key, TabIndex tabIndex) {
        saveInt(key.toString(), tabIndex.getIndex());
    }

    // -----------------------------------------------------------------------------------------------------------------

    public TabIndex getTabIndex(SdsKeys key, TabIndex defaultValue) {
        if (existKey(key.toString())) {
            return TabIndex.valueOf(getInt(key.toString()));
        } else {
            return defaultValue;
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    private boolean existKey(String key) {
        return dataStore.containsKey(key);
    }

    // -----------------------------------------------------------------------------------------------------------------

}
