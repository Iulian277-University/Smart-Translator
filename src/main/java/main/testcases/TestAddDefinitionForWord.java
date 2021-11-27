package main.testcases;

import actions.AddDefinitionForWord;
import entities.Definition;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.PrintWordsFromLanguage;

import java.util.ArrayList;
import java.util.Map;

public final class TestAddDefinitionForWord {
    private TestAddDefinitionForWord() {}

    public static void testAddDefinitionForWord() {

        // Before-FR
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        PrintWordsFromLanguage.printWords(wordsMap, "fr");

        // Generate a new definition
        ArrayList<String> textDef = new ArrayList<>();
        Definition def = new Definition("Larousse1", "synonyms", 2010, textDef);

        AddDefinitionForWord.addDefinitionForWord("manger", "fr", def);

        // After-FR
        PrintWordsFromLanguage.printWords(wordsMap, "fr");
    }
}
