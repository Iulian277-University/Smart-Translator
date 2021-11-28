package main.testcases;

import actions.RemoveDefinitionForWord;
import common.Constants;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import org.apache.commons.lang3.StringUtils;
import utils.FilterEntities;
import utils.PrintWordsFromLanguage;

import java.util.ArrayList;
import java.util.Map;

public final class TestRemoveDefinitionForWord {
    private TestRemoveDefinitionForWord() {}

    public static void testRemoveDefinitionForWord() {

        System.out.println("--- RemoveDefinitionForWord - Testcase (1) ---");
        // Before-FR
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        String before = "";
        Word word = FilterEntities.filterWordsByName(wordsMap.get(Constants.FRENCH_LANGUAGE), "chat");
        if(word != null) {
            before = word.getDefinitions().toString();
        }

        RemoveDefinitionForWord.removeDefinition("chat", Constants.FRENCH_LANGUAGE, "Larousse");

        // After-FR
        String after = "";
        if(word != null) {
            after = word.getDefinitions().toString();
        }
        System.out.println("Diff: " + StringUtils.difference(before, after));


        System.out.println("--- RemoveDefinitionForWord - Testcase (2) ---");
        // Before-FR
        before = "";
        word = FilterEntities.filterWordsByName(wordsMap.get(Constants.FRENCH_LANGUAGE), "chat");
        if(word != null) {
            before = word.getDefinitions().toString();
        }

        RemoveDefinitionForWord.removeDefinition("chat", Constants.FRENCH_LANGUAGE, "Larousse");

        // After-FR
        after = "";
        if(word != null) {
            after = word.getDefinitions().toString();
        }
        System.out.println("Diff: " + StringUtils.difference(before, after));
        System.out.println();
    }
}
