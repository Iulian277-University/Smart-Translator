package actions;

import entities.Word;
import json_deserialization.DeserializeDictionaries;

import java.util.ArrayList;
import java.util.Map;

/** This is a class used for appending a given word in a language dictionary */
public final class AddWord {
    private AddWord() {}

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    /**
     * Remove a word from a given language dictionary
     * @param word 'word_name' as a string
     * @param language of the word as a string
     * @return the status of the action (true - added successfully; false - couldn't add the word)
     */
    public static boolean addWord(Word word, String language) {

        ArrayList<Word> languageWords = wordsMap.get(language);
        // The dictionary in 'language' doesn't exist
        if(languageWords == null) {
            ArrayList<Word> firstWord = new ArrayList<>();
            firstWord.add(word);
            wordsMap.put(language, firstWord);
            System.out.println("The word '" + word.getWordName() + "' was successfully added in '" + language + "' dictionary");
            return true;
        }

        // The word is already in the list
        if(languageWords.contains(word)) {
            System.out.println("The word '" + word.getWordName() + "' is already in the list");
            return false;
        }

        // Append the word to the list
        languageWords.add(word);
        System.out.println("The word '" + word.getWordName() + "' was successfully added in '" + language + "' dictionary");
        return true;
    }
}
