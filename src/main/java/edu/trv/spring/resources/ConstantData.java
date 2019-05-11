package edu.trv.spring.resources;

import java.util.ResourceBundle;

public enum ConstantData {

    AUTHOR("author"),
    YEAR("year");

    static ResourceBundle bundle = getBundle();

    private final String key;

    ConstantData(String resourceKey){
        this.key = resourceKey;
    }

    @Override
    public String toString() {
        return bundle.getString(this.key);
    }

    private static ResourceBundle getBundle(){
        return ResourceBundle.getBundle("constant_data");
    }

    public static void refresh(){
        bundle = getBundle();
    }

}
