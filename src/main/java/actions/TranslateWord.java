package actions;

import common.Constants;
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

        if(fromLanguage.equals(toLanguage)) {
            return word;
        }

        // 'fromLanguage' isn't in the database
        ArrayList<Word> fromLanguageWords = wordsMap.get(fromLanguage);
        if((fromLanguageWords == null) && (!fromLanguage.equals(Constants.ENGLISH_LANGUAGE))) {
            return null;
        }

        // 'toLanguage' isn't in the database
        ArrayList<Word> toLanguageWords = wordsMap.get(toLanguage);
        if((toLanguageWords == null) && (!toLanguage.equals(Constants.ENGLISH_LANGUAGE))) {
            return null;
        }

        // For finding the closest match, I'm using the 'LevenshteinDistanceAlgorithm'
        // https://en.wikipedia.org/wiki/Levenshtein_distance

        // Filter word by 'name' in the 'fromLanguage' database and get the object
        Word inputWord = null;
        String inputWordString = "";
        if(fromLanguageWords != null) {
            inputWord = FilterEntities.filterWordsByName(fromLanguageWords, word);
            if (inputWord == null) {
                inputWord = closestMatch(fromLanguageWords, word);
                if (inputWord == null) {
                    return null;
                }
            }
            inputWordString = inputWord.getWord_en();
        } else {
            inputWordString = word;
        }


        // Filter word by 'name_en' in the 'toLanguage' database and get the object
        Word outputWord = null;
        String outputWordString = "";
        if(toLanguageWords != null) {
            outputWord = FilterEntities.filterWordsByEnglishName(toLanguageWords, inputWordString);
            if(outputWord == null) {
                outputWord = closestMatch(toLanguageWords, word);
                if(outputWord == null) {
                    return null;
                }
            }
            outputWordString = outputWord.getWord();
        } else {
            outputWordString = inputWord.getWord_en();
        }

        // Return the word-translation
        return outputWordString;
    }

    public static String translateWordWithFeedback(String word, String fromLanguage, String toLanguage) {
        word = word.toLowerCase();
        if(word.isEmpty() || fromLanguage.isEmpty() || toLanguage.isEmpty()) {
            System.out.println("Non-empty fields required");
        }

        if(fromLanguage.equals(toLanguage)) {
            return word;
        }

        // fromLanguage isn't in the database
        ArrayList<Word> fromLanguageWords = wordsMap.get(fromLanguage);
        if((fromLanguageWords == null) && (!fromLanguage.equals(Constants.ENGLISH_LANGUAGE))) {
            System.out.println("The dictionary in language '" + fromLanguage + "' doesn't exist");
            return null;
        }

        // toLanguage isn't in the database
        ArrayList<Word> toLanguageWords = wordsMap.get(toLanguage);
        if((toLanguageWords == null) && (!toLanguage.equals(Constants.ENGLISH_LANGUAGE))) {
            System.out.println("The dictionary in language '" + toLanguage + "' doesn't exist");
            return null;
        }

        // For finding the closest match, I'm using the 'LevenshteinDistanceAlgorithm'
        // https://en.wikipedia.org/wiki/Levenshtein_distance

        // Filter word by name in the 'fromLanguage' database and get the object
        Word inputWord = null;
        String inputWordString = "";
        if(fromLanguageWords != null) {
            inputWord = FilterEntities.filterWordsByName(fromLanguageWords, word);
            if (inputWord == null) {
                inputWord = closestMatch(fromLanguageWords, word);
                if (inputWord == null) {
                    System.out.println("The '" + fromLanguage + "' word '" + word + "' isn't in the '" + fromLanguage + "' dictionary");
                    return null;
                }
            }
            inputWordString = inputWord.getWord_en();
        } else {
            inputWordString = word;
        }

        // Filter word by 'name_en' in the 'toLanguage' database and get the object
        Word outputWord = null;
        String outputWordString = "";
        if(toLanguageWords != null) {
            outputWord = FilterEntities.filterWordsByEnglishName(toLanguageWords, inputWordString);
            if(outputWord == null) {
                outputWord = closestMatch(toLanguageWords, word);
                if(outputWord == null) {
                    System.out.println("The '" + fromLanguage + " 'word '" + word + "' isn't in the '" + toLanguage + "' dictionary");
                    return null;
                }
            }
            outputWordString = outputWord.getWord();
        } else {
            outputWordString = inputWord.getWord_en();
        }

        // Return the word-translation
        return outputWordString;
    }
}
