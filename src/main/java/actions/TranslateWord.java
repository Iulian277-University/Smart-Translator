package actions;

import common.Constants;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.FilterEntities;

import java.util.ArrayList;
import java.util.Map;

public final class TranslateWord {
    private TranslateWord() {}

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    public static String translateWord(String word, String fromLanguage, String toLanguage) {
        // fromLanguage isn't in the database
        ArrayList<Word> fromLanguageWords = wordsMap.get(fromLanguage);
        if(fromLanguageWords == null) {
//            System.out.println("The dictionary in language " + fromLanguage + " doesn't exist");
            return null;
        }

        // toLanguage isn't in the database
        ArrayList<Word> toLanguageWords = wordsMap.get(toLanguage);
        if(toLanguageWords == null) {
//            System.out.println("The dictionary in language " + toLanguage + " doesn't exist");
            return null;
        }

        // Filter word by name in the 'fromLanguage' database and get the object
        Word inputWord = FilterEntities.filterWordsByName(fromLanguageWords, word);
        if(inputWord == null) {
//            System.out.println("The word '" + word + "' isn't in the '" + fromLanguage + "' dictionary");
            return null;
        }

        // Filter word by name_en in the 'toLanguage' database and get the object
        Word outputWord = FilterEntities.filterWordsByEnglishName(toLanguageWords, inputWord.getWord_en());
        if(outputWord == null) {
//            System.out.println("The word '" + inputWord.getWord_en() + "' isn't in the '" + toLanguage + "' dictionary");
            return null;
        }

        // Return the word-translation
        return outputWord.getWord();
    }
}
