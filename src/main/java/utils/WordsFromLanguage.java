package utils;

import entities.Word;

import java.util.ArrayList;
import java.util.Map;

/** This is a handler class for getting words from a specific language */
public final class WordsFromLanguage {
    private WordsFromLanguage() {}

    /**
     * Print the words from a given language
     * @param wordsMap: map with all words
     * @param language as a string
     */
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

    /**
     * Get the words from a given language
     * @param wordsMap: map with all words
     * @param language as a string
     * @return a list of words from a queried language
     */
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
