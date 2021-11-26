package main.testcases;

import actions.AddDefinitionForWord;
import entities.Definition;
import entities.Word;
import json_deserialization.DeserializeDictionaries;

import java.util.ArrayList;
import java.util.Map;

public final class TestAddDefinitionForWord {
    private TestAddDefinitionForWord() {}

    public static void testAddDefinitionForWord() {

        // Before
        System.out.println("Before-FR");
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        ArrayList<Word> frWords = wordsMap.get("fr");
        for(Word word: frWords) {
            System.out.println(word);
        }
        System.out.println();

        // Generate a new definition
        ArrayList<String> textDef = new ArrayList<>();
        Definition def = new Definition("Larousse1", "synonyms", 2010, textDef);

        AddDefinitionForWord.addDefinitionForWord("manger", "fr", def);

        // After
        System.out.println("Before-FR");
        ArrayList<Word> fr2Words = wordsMap.get("fr");
        for(Word word: fr2Words) {
            System.out.println(word);
        }
        System.out.println();

    }

}
