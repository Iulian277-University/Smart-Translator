package actions;

import entities.Word;
import json_deserialization.DeserializeDictionaries;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class RemoveWord {
    private RemoveWord() {}

    // Map<Language_Name, List_Of_Words>
    private static Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    private static Word filterWordsByName(ArrayList<Word> words, String wordName) {
        List<Word> wordsFiltered = words
                .stream()
                .filter(w -> w.getWord().equals(wordName))
                .collect(Collectors.toList());

        if(wordsFiltered.isEmpty()) {
            return null;
        }

        return wordsFiltered.get(0);
    }

    public static boolean removeWord(String word, String language) {
        ArrayList<Word> languageWords = wordsMap.get(language);
        // Dictionary contains zero words for 'language'
        if(languageWords == null) {
            return false;
        }

        Word filteredWord = filterWordsByName(languageWords, word);
        // The word isn't in the dictionary
        if(filteredWord == null) {
            return false;
        }

        languageWords.remove(filteredWord);
        return true;
    }

}
