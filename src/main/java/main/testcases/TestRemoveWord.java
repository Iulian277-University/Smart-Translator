package main.testcases;

import actions.AddWord;
import actions.RemoveWord;
import common.Constants;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import org.apache.commons.lang3.StringUtils;
import utils.PrintWordsFromLanguage;

import java.util.ArrayList;
import java.util.Map;

public final class TestRemoveWord {
    private TestRemoveWord() {}

    public static void testRemoveWord() {
        // Before-FR
        System.out.println("--- RemoveWord - Testcase (1) ---");
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        String before = PrintWordsFromLanguage.wordsList(wordsMap, Constants.FRENCH_LANGUAGE);

        RemoveWord.removeWord("bonjour", Constants.FRENCH_LANGUAGE);

        // After-FR
        String after = PrintWordsFromLanguage.wordsList(wordsMap, Constants.FRENCH_LANGUAGE);


        // Before-FR
        System.out.println("--- RemoveWord - Testcase (2) ---");
        before = PrintWordsFromLanguage.wordsList(wordsMap, Constants.FRENCH_LANGUAGE);

        RemoveWord.removeWord("bonjour", Constants.FRENCH_LANGUAGE);

        // After-FR
        after = PrintWordsFromLanguage.wordsList(wordsMap, Constants.FRENCH_LANGUAGE);
        System.out.println();
    }
}
