package utils;

import entities.Word;

import java.util.ArrayList;
import java.util.Map;

public final class PrintWordsFromLanguage {
    private PrintWordsFromLanguage() {}

    public static void printWords(Map<String, ArrayList<Word>> wordsMap, String language) {
        ArrayList<Word> languageWords = wordsMap.get(language);
        if(languageWords == null) {
            System.out.println("No words in " + language);
            return;
        }

        for(Word word: languageWords) {
            System.out.println(word);
        }
        System.out.println();
    }

    public static String wordsList(Map<String, ArrayList<Word>> wordsMap, String language) {
        ArrayList<Word> languageWords = wordsMap.get(language);
        if(languageWords == null) {
            return "";
        }

        StringBuilder retString = new StringBuilder();
        for(Word word: languageWords) {
            retString.append(word.toString());
        }
        return retString.toString();
    }

}
