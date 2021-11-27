package main.testcases;

import actions.AddWord;
import actions.RemoveWord;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.PrintWordsFromLanguage;

import java.util.ArrayList;
import java.util.Map;

public final class TestRemoveWord {
    private TestRemoveWord() {}

    public static void testRemoveWord() {
        // Before-FR
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        PrintWordsFromLanguage.printWords(wordsMap, "fr");

        RemoveWord.removeWord("jeu", "fr");

        // After-FR
        PrintWordsFromLanguage.printWords(wordsMap, "fr");
    }
}
