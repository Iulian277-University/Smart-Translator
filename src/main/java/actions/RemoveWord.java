package actions;

import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.FilterEntities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class RemoveWord {
    private RemoveWord() {}

    // Map<Language_Name, List_Of_Words>
    private static Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();



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
        System.out.println("The word '" + filteredWord.getWord() + "' was successfully removed from '" + language + "' dictionary");
        return true;
    }

}
