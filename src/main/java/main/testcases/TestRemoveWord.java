package main.testcases;

import actions.AddWord;
import actions.RemoveWord;
import entities.Word;
import json_deserialization.DeserializeDictionaries;

import java.util.ArrayList;
import java.util.Map;

public final class TestRemoveWord {
    private TestRemoveWord() {}

    public static void testRemoveWord() {
        // Before
        System.out.println("Before-FR");
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        ArrayList<Word> frWords = wordsMap.get("fr");
        for(Word word: frWords) {
            System.out.println(word.getWord());
        }
        System.out.println();

        RemoveWord.removeWord("jeu", "fr");

        // After
        System.out.println("After-FR");
        ArrayList<Word> fr2Words = wordsMap.get("fr");
        for(Word word: fr2Words) {
            System.out.println(word.getWord());
        }
        System.out.println();


    }
}
