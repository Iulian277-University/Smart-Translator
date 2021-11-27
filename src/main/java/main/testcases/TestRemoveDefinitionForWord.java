package main.testcases;

import actions.RemoveDefinitionForWord;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.PrintWordsFromLanguage;

import java.util.ArrayList;
import java.util.Map;

public final class TestRemoveDefinitionForWord {
    private TestRemoveDefinitionForWord() {}

    public static void testRemoveDefinitionForWord() {
        // Before-FR
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        PrintWordsFromLanguage.printWords(wordsMap, "fr");

        RemoveDefinitionForWord.removeDefinition("chat", "fr", "Larousse");

        // After-FR
        PrintWordsFromLanguage.printWords(wordsMap, "fr");
    }
}
