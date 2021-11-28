package utils;

import entities.Word;

import java.util.List;
import java.util.stream.Collectors;

/** This is a handler class for filtering words by 'name' and 'en_name' */
public final class FilterEntities {
    private FilterEntities() {}

    /**
     * Get the word as objects from string
     * @param words: list of words as objects
     * @param wordName as a string
     * @return the filtered word as object or null if didn't find it
     */
    public static Word filterWordsByName(List<Word> words, String wordName) {
        List<Word> wordsFiltered = words
                .stream()
                .filter(w -> w.getWordName().equals(wordName))
                .collect(Collectors.toList());

        if(wordsFiltered.isEmpty()) {
            return null;
        }

        return wordsFiltered.get(0);
    }


    /**
     * Get the word as object from string
     * @param words: list of words as objects
     * @param wordNameInEnglish: the english attribute of the queried word
     * @return the filtered word as object or null if didn't find it
     */
    public static Word filterWordsByEnglishName(List<Word> words, String wordNameInEnglish) {
        List<Word> wordsFiltered = words
                .stream()
                .filter(w -> w.getWordEn().equals(wordNameInEnglish))
                .collect(Collectors.toList());

        if(wordsFiltered.isEmpty()) {
            return null;
        }

        return wordsFiltered.get(0);
    }
}
