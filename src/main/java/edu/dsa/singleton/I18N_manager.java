package edu.dsa.singleton;

import java.util.*;

public class I18N_manager {

    private static I18N_manager instance;

    private I18N_manager(){}

    public static I18N_manager getInstance(){
        if (instance == null) instance = new I18N_manager();
        return instance;
    }

    public Collection<String> getWords(String language){
        Locale locale = new Locale(language);
        ResourceBundle resources = ResourceBundle.getBundle("MyLabels", locale);
        Map<String, String> map = new HashMap<>();
        Enumeration<String> keys = resources.getKeys();

        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            map.put(key, resources.getString(key));
        }
        return map.values();
    }

}
