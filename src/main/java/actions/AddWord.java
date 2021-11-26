package actions;

import entities.Word;
import json_deserialization.DeserializeDictionaries;

import java.util.ArrayList;
import java.util.Map;

public final class AddWord {
    private AddWord() {}

    // Map<Language_Name, List_Of_Words>
    private static Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    public static boolean addWord(Word word, String language) {

        ArrayList<Word> languageWords = wordsMap.get(language);
        // The dictionary with 'language' doesn't exist
        if(languageWords == null) {
            ArrayList<Word> firstWord = new ArrayList<>();
            firstWord.add(word);
            wordsMap.put(language, firstWord);
            return true;
        }

        if(languageWords.contains(word)) {
            return false;
        }

        languageWords.add(word);
        return true;
    }
}