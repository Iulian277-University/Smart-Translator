package actions;

import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.FilterEntities;

import java.util.ArrayList;
import java.util.Map;

/** This is a class used for removing a given word from a language dictionary */
public final class RemoveWord {
    private RemoveWord() {}

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    /**
     * Add a word in a given language dictionary
     * @param word 'word_name' as a string
     * @param language of the word as a string
     * @return the status of the action (true - removed successfully; false - couldn't remove the word)
     */
    public static boolean removeWord(String word, String language) {
        ArrayList<Word> languageWords = wordsMap.get(language);
        // Dictionary contains zero words in 'language'
        if(languageWords == null) {
            System.out.println("Dictionary doesn't contain words in language '" + language + "'");
            return false;
        }

        Word filteredWord = FilterEntities.filterWordsByName(languageWords, word);
        // The word isn't in the dictionary
        if(filteredWord == null) {
            System.out.println("The word '" + word + "' isn't in the dictionary");
            return false;
        }

        // Remove the word
        languageWords.remove(filteredWord);
        System.out.println("The word '" + filteredWord.getWordName() + "' was successfully removed from '" + language + "' dictionary");
        return true;
    }
}
