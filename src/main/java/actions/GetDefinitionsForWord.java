package actions;

import entities.Definition;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.FilterEntities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** This is a class used for appending a definition for a given word */
public final class GetDefinitionsForWord {
    private GetDefinitionsForWord() {}

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    /**
     * Collect in a list all definitions from a given word
     * @param word 'word_name' as a string
     * @param language fo the word as a string
     * @return a list of the queried definitions
     */
    public static List<Definition> getDefinitionsForWord(String word, String language) {
        // The dictionary in 'language' doesn't exist
        ArrayList<Word> languageWords = wordsMap.get(language);
        if(languageWords == null) {
            System.out.println("The dictionary in language '" + language + "' doesn't exist");
            return new ArrayList<>();
        }

        // The word isn't in the dictionary
        Word filteredWord = FilterEntities.filterWordsByName(languageWords, word);
        if(filteredWord == null) {
            System.out.println("The word '" + word + "' isn't in the '" + language + "' dictionary");
            return new ArrayList<>();
        }

        // Sort definitions in ascending order by 'year'
        List<Definition> filteredWordDefinitions = filteredWord.getDefinitions();
        List<Definition> allDefinitions = new ArrayList<>(filteredWordDefinitions);

        return allDefinitions
                .stream()
                .sorted(Comparator.comparing(Definition::getYear))
                .collect(Collectors.toList());
    }
}
