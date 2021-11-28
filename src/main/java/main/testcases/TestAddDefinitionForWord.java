package main.testcases;

import actions.AddDefinitionForWord;
import common.Constants;
import entities.Definition;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import org.apache.commons.lang3.StringUtils;
import utils.FilterEntities;
import utils.PrintWordsFromLanguage;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public final class TestAddDefinitionForWord {
    private TestAddDefinitionForWord() {}

    public static void testAddDefinitionForWord() {

        System.out.println("--- AddDefinitionForWord - Testcase (1) ---");
        // Before-RO
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        String before = "";
        Word word = FilterEntities.filterWordsByName(wordsMap.get(Constants.ROMANIAN_LANGUAGE), "pisică");
        if(word != null) {
            before = word.getDefinitions().toString();
        }

        // Generate a new definition
        Definition def = new Definition("DEX", "synonyms", 2007, new ArrayList<>());
        AddDefinitionForWord.addDefinitionForWord("pisică", Constants.ROMANIAN_LANGUAGE, def);

        // After-FR
        String after = "";
        if(word != null) {
            after = word.getDefinitions().toString();
        }
        System.out.println("Diff: " + StringUtils.difference(before, after));


        System.out.println("--- AddDefinitionForWord - Testcase (2) ---");
        // Before-RO
        before = "";
        word = FilterEntities.filterWordsByName(wordsMap.get(Constants.ROMANIAN_LANGUAGE), "pisic");
        if(word != null) {
            before = word.getDefinitions().toString();
        }

        // Generate a new definition
        def = new Definition("DEX", "synonyms", 2017, new ArrayList<>());
        AddDefinitionForWord.addDefinitionForWord("pisic", Constants.ROMANIAN_LANGUAGE, def);

        // After-FR
        after = "";
        if(word != null) {
            after = word.getDefinitions().toString();
        }
        System.out.println("Diff: " + StringUtils.difference(before, after));
        System.out.println();
    }
}
