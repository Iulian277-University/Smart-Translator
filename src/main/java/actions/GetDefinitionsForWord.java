package actions;

import entities.Definition;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.FilterEntities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public final class GetDefinitionsForWord {
    private GetDefinitionsForWord() {}

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    public static ArrayList<Definition> getDefinitionsForWord(String word, String language) {
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
        ArrayList<Definition> filteredWordDefinitions = filteredWord.getDefinitions();
        ArrayList<Definition> allDefinitions = new ArrayList<>(filteredWordDefinitions);

        return (ArrayList<Definition>) allDefinitions
                .stream()
                .sorted(Comparator.comparing(Definition::getYear))
                .collect(Collectors.toList());

    }
}
