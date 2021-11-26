package actions;

import entities.Word;
import json_deserialization.DeserializeDictionaries;

import java.util.ArrayList;
import java.util.Map;

public final class AddWord {
    private AddWord() {}

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    public static boolean addWord(Word word, String language) {

        ArrayList<Word> languageWords = wordsMap.get(language);
        // The dictionary in 'language' doesn't exist
        if(languageWords == null) {
            ArrayList<Word> firstWord = new ArrayList<>();
            firstWord.add(word);
            wordsMap.put(language, firstWord);
            System.out.println("The word '" + word.getWord() + "' was successfully added in '" + language + "' dictionary");
            return true;
        }

        // The word is already in the list
        if(languageWords.contains(word)) {
            System.out.println("The word '" + word.getWord() + "' is already in the list");
            return false;
        }

        // Append the word to the list
        languageWords.add(word);
        System.out.println("The word '" + word.getWord() + "' was successfully added in '" + language + "' dictionary");
        return true;
    }
}
