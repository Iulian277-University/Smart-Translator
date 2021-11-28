package actions;

import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.FilterEntities;

import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public final class TranslateWord {
    private TranslateWord() {}

    private static Word closestMatch(ArrayList<Word> languageWords, String word) {
        // Find the closest match
        int distance = Integer.MAX_VALUE;
        Word closestMatch = null;
        for(Word currWord: languageWords) {
            int currDistance = StringUtils.getLevenshteinDistance(word, currWord.getWord());
            if(currDistance < distance) {
                distance = currDistance;
                closestMatch = currWord;
            }
        }

        // Not a good approximation
        if(distance > 0.25 * word.length()) {
            closestMatch = null;
        }
        return closestMatch;
    }


    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    public static String translateWord(String word, String fromLanguage, String toLanguage) {
        word = word.toLowerCase();
        if(word.isEmpty() || fromLanguage.isEmpty() || toLanguage.isEmpty()) {
            return null;
        }

        // fromLanguage isn't in the database
        ArrayList<Word> fromLanguageWords = wordsMap.get(fromLanguage);
        if(fromLanguageWords == null) {
            return null;
        }

        // toLanguage isn't in the database
        ArrayList<Word> toLanguageWords = wordsMap.get(toLanguage);
        if(toLanguageWords == null) {
            return null;
        }

        // For finding the closest match, I'm using the 'LevenshteinDistanceAlgorithm'
        // https://en.wikipedia.org/wiki/Levenshtein_distance

        // Filter word by name in the 'fromLanguage' database and get the object
        Word inputWord = FilterEntities.filterWordsByName(fromLanguageWords, word);
        if(inputWord == null) {
            inputWord = closestMatch(fromLanguageWords, word);
            if(inputWord == null) {
                return null;
            }
        }

        // Filter word by name_en in the 'toLanguage' database and get the object
        Word outputWord = FilterEntities.filterWordsByEnglishName(toLanguageWords, inputWord.getWord_en());
        if(outputWord == null) {
            outputWord = closestMatch(toLanguageWords, word);
            if(outputWord == null) {
                return null;
            }
        }

        // Return the word-translation
        return outputWord.getWord();
    }

    public static String translateWordWithFeedback(String word, String fromLanguage, String toLanguage) {
        if(word.isEmpty() || fromLanguage.isEmpty() || toLanguage.isEmpty()) {
            System.out.println("Non-empty fields required");
        }

        // fromLanguage isn't in the database
        ArrayList<Word> fromLanguageWords = wordsMap.get(fromLanguage);
        if(fromLanguageWords == null) {
            System.out.println("The dictionary in language '" + fromLanguage + "' doesn't exist");
            return null;
        }

        // toLanguage isn't in the database
        ArrayList<Word> toLanguageWords = wordsMap.get(toLanguage);
        if(toLanguageWords == null) {
            System.out.println("The dictionary in language '" + toLanguage + "' doesn't exist");
            return null;
        }

        // Filter word by name in the 'fromLanguage' database and get the object
        Word inputWord = FilterEntities.filterWordsByName(fromLanguageWords, word);
        if(inputWord == null) {
            inputWord = closestMatch(fromLanguageWords, word);
            if(inputWord == null) {
                System.out.println("The word '" + word + "' isn't in the '" + fromLanguage + "' dictionary");
                return null;
            }
        }

        // Filter word by name_en in the 'toLanguage' database and get the object
        Word outputWord = FilterEntities.filterWordsByEnglishName(toLanguageWords, inputWord.getWord_en());
        if(outputWord == null) {
            outputWord = closestMatch(toLanguageWords, word);
            if(outputWord == null) {
                System.out.println("The word '" + word + "' isn't in the '" + toLanguage + "' dictionary");
                return null;
            }
        }

        // Return the word-translation
        return outputWord.getWord();
    }
}
