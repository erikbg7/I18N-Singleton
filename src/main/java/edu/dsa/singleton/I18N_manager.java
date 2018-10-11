package edu.dsa.singleton;

import org.apache.log4j.Logger;

import java.util.*;

public class I18N_manager {

    private static I18N_manager instance = null;
    private HashMap<String, ResourceBundle> cache;
    private static Logger log=Logger.getLogger(I18N_manager.class);

    private I18N_manager(){
        this.cache = new HashMap<>();
    }

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

    public String getWord(String language, String key) {
        log.info("Language: "+language+" "+" key:" +key);

        ResourceBundle rb = cache.get(language);
        if (rb == null)  {
            log.info("utilitzo el carregador de classe");

            Locale locale = new Locale(language);
            rb = ResourceBundle.getBundle("MyLabels", locale);
            cache.put(language, rb);
        }
        else log.info("Ja ho tinc a cache");

        log.info("return "+rb.getString(key));
        return rb.getString(key);
    }
}
