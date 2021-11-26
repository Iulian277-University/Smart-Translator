package main.testcases;

import actions.AddWord;
import entities.Word;
import json_deserialization.DeserializeDictionaries;

import java.util.ArrayList;
import java.util.Map;

public final class TestAddWord {
    private TestAddWord() {}

    public static void testAddWord() {

        // Before
        System.out.println("Before-FR");
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();
        ArrayList<Word> frWords = wordsMap.get("fr");
        for(Word word: frWords) {
            System.out.println(word.getWord());
        }
        System.out.println();

        // Before-EN
        System.out.println("Before-EN");
        ArrayList<Word> enWords = wordsMap.get("en");
        if(enWords != null) {
            for (Word word : enWords) {
                System.out.println(word.getWord());
            }
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

        Word testWord = new Word("jeu", "wordTest_en", "noun", singular, plural, null);
        AddWord.addWord(testWord, "fr");

        // After-EN
        System.out.println("After-EN");
        ArrayList<Word> en2Words = wordsMap.get("fr");
        if(en2Words != null) {
            for (Word word : en2Words) {
                System.out.println(word.getWord());
            }
        }
    }
}
