package edu.dsa.singleton;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;

/**
 * Unit test for i18N Manager
 */
public class I18NmanagerTest
{
    private I18N_manager i18n;

    private List<String> setEnglish;
    private List<String> setCatalan;
    private List<String> setSpanish;
    private List<String> setGerman;

    //Before: load a set of each language
    @Before
    public void setUp() {

        this.i18n = I18N_manager.getInstance();

        this.setEnglish = new ArrayList<>(i18n.getWords("en"));
        this.setCatalan = new ArrayList<>(i18n.getWords("ca"));
        this.setSpanish = new ArrayList<>(i18n.getWords("es"));
        this.setGerman = new ArrayList<>(i18n.getWords("de"));
    }

    //After: delete the monster
    @After
    public void tearDown() {
        this.i18n=null;
    }

    //Test: check that every set of words is correct
    @Test
    public void testingWordsAreCorrect()
    {
        //English
        System.out.println(setEnglish);
        Assert.assertEquals(4, setEnglish.size());
        List<String> expectedEnglish = Arrays.asList("Welcome", "Settings", "Menu", "Close session");
        Assert.assertEquals(expectedEnglish, setEnglish);

        //Catalan
        System.out.println(setCatalan);
        Assert.assertEquals(4, setCatalan.size());
        List<String> expectedCatalan = Arrays.asList("Benvingut", "Configuració", "Menú", "Tancar sessió");
        Assert.assertEquals(expectedCatalan, setCatalan);

        //Spanish
        System.out.println(setSpanish);
        Assert.assertEquals(4, setSpanish.size());
        List<String> expectedSpanish = Arrays.asList("Bienvenido", "Configuración", "Menú", "Cerrar sesión");
        Assert.assertEquals(expectedSpanish, setSpanish);

        //Deutsch (German)
        System.out.println(setGerman);
        Assert.assertEquals(4, setGerman.size());
        List<String> expectedGerman = Arrays.asList("Willkommen", "Konfiguration", "Speisekarte", "Sitzung schließen");
        Assert.assertEquals(expectedGerman, setGerman);
    }

    @Test
    public void testGetWord() {
        Assert.assertEquals("Benvingut",I18N_manager.getInstance().getWord("ca","L1"));
        Assert.assertEquals("Benvingut",I18N_manager.getInstance().getWord("ca","L1"));
    }


    @Test
    public void testGetWordWithLocaleNotFound() {
        Assert.assertEquals("Welcome",I18N_manager.getInstance().getWord("ru","L1"));

    }
    }
