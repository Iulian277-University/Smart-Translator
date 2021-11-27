package main.testcases;

import actions.AddWord;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.PrintWordsFromLanguage;

import java.util.ArrayList;
import java.util.Map;

public final class TestAddWord {
    private TestAddWord() {}

    public static void testAddWord() {

        // Before-FR
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        PrintWordsFromLanguage.printWords(wordsMap, "fr");

        // Test Word for actions
        ArrayList<String> singular = new ArrayList<>();
        singular.add("singular1");
        singular.add("singular2");
        ArrayList<String> plural = new ArrayList<>();
        singular.add("plural1");
        singular.add("plural2");
        singular.add("plural3");

        Word testWord = new Word("jeu", "wordTest_en", "noun", singular, plural, null);
        AddWord.addWord(testWord, "fr");

        // After-FR
        PrintWordsFromLanguage.printWords(wordsMap, "fr");
    }
}
