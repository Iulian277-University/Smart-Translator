package utils;

import entities.Word;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class FilterEntities {
    private FilterEntities() {}

    public static Word filterWordsByName(ArrayList<Word> words, String wordName) {
        List<Word> wordsFiltered = words
                .stream()
                .filter(w -> w.getWord().equals(wordName))
                .collect(Collectors.toList());

        if(wordsFiltered.isEmpty()) {
            return null;
        }

        return wordsFiltered.get(0);
    }


}
