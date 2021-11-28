package main.testcases;

import actions.AddWord;
import common.Constants;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import org.apache.commons.lang3.StringUtils;
import utils.PrintWordsFromLanguage;

import java.util.ArrayList;
import java.util.Map;

public final class TestAddWord {
    private TestAddWord() {}

    public static void testAddWord() {

        System.out.println();
        System.out.println("--- AddWord - Testcase (1) ---");
        // Before-FR
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        String before = PrintWordsFromLanguage.wordsList(wordsMap, Constants.FRENCH_LANGUAGE);

        // TestWord
        ArrayList<String> singular = new ArrayList<>();
        singular.add("singular1");
        singular.add("singular2");
        ArrayList<String> plural = new ArrayList<>();
        plural.add("plural1");
        plural.add("plural2");
        plural.add("plural3");

        Word testWord = new Word("pomme", "wordTest_en", "noun", singular, plural, null);
        AddWord.addWord(testWord, Constants.FRENCH_LANGUAGE);

        // After-FR
        String after = PrintWordsFromLanguage.wordsList(wordsMap, Constants.FRENCH_LANGUAGE);
        System.out.println("Diff: " + StringUtils.difference(before, after));


        System.out.println("--- AddWord - Testcase (2) ---");
        // Before-FR
        before = PrintWordsFromLanguage.wordsList(wordsMap, Constants.FRENCH_LANGUAGE);

        // TestWord
        AddWord.addWord(testWord, Constants.FRENCH_LANGUAGE);

        // After-FR
        after = PrintWordsFromLanguage.wordsList(wordsMap, Constants.FRENCH_LANGUAGE);
        System.out.println("Diff: " + StringUtils.difference(before, after));
        System.out.println();
    }
}
