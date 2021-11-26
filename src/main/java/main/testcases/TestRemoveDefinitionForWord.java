package main.testcases;

import actions.RemoveDefinitionForWord;
import entities.Word;
import json_deserialization.DeserializeDictionaries;

import java.util.ArrayList;
import java.util.Map;

public final class TestRemoveDefinitionForWord {
    private TestRemoveDefinitionForWord() {}

    public static void testRemoveDefinitionForWord() {

        // Before
        System.out.println("Before-FR");
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        ArrayList<Word> frWords = wordsMap.get("fr");
        for(Word word: frWords) {
            System.out.println(word);
        }
        System.out.println();

        RemoveDefinitionForWord.removeDefinition("chat", "fr", "Larousse");

        // After
        System.out.println("After-FR");
        ArrayList<Word> fr2Words = wordsMap.get("fr");
        for(Word word: fr2Words) {
            System.out.println(word);
        }
        System.out.println();
    }
}
