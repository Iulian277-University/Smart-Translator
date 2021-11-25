package main.testcases;

import actions.AddWord;
import entities.Word;
import json_deserialization.DeserializeDictionaries;

import java.util.ArrayList;
import java.util.Map;

public class TestAddBook {
    private TestAddBook() {}

    public static void testAddBook() {

        // Before
        System.out.println("Before");
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        ArrayList<Word> frWords = wordsMap.get("fr");
        for(Word word: frWords) {
            System.out.println(word.getWord());
        }
        System.out.println();

        // Test Word for actions
        ArrayList<String> singular = new ArrayList<>();
        singular.add("singular1");
        singular.add("singular2");
        ArrayList<String> plural = new ArrayList<>();
        singular.add("plural1");
        singular.add("plural2");
        singular.add("plural3");

        Word testWord = new Word("wordTest", "wordTest_en", "noun", singular, plural, null);
        AddWord.addWord(testWord, "fr");

        // After
        System.out.println("After");
        ArrayList<Word> fr2Words = wordsMap.get("fr");
        for(Word word: fr2Words) {
            System.out.println(word.getWord());
        }
    }
}
