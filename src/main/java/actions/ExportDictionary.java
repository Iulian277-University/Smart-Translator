package actions;

import entities.Definition;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import json_serialization.SerializeDictionary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/** This is a class used for exporting a dictionary */
public final class ExportDictionary {
    private ExportDictionary() {}

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    /**
     * Export a dictionary with a given language
     * @param language of the dictionary to be exported
     */
    public static void exportDictionary(String language) {
        // The dictionary in 'language' doesn't exist
        ArrayList<Word> languageWords = wordsMap.get(language);
        if(languageWords == null) {
            System.out.println("The dictionary in language '" + language + "' doesn't exist");
            return;
        }

        // Copy the words to a new list to manipulate them
        ArrayList<Word> wordsToExport = new ArrayList<>(wordsMap.get(language));

        // Sort inside definitions in ascending order by 'year'
        for(Word word: wordsToExport) {
            if(word.getDefinitions() != null) {
                word.setDefinitions(
                        word.getDefinitions()
                                .stream()
                                .sorted(Comparator.comparing(Definition::getYear))
                                .collect(Collectors.toList())
                );
            }
        }

        // Sort words in ascending order alphabetically
        wordsToExport = (ArrayList<Word>) wordsToExport
                .stream()
                .sorted(Comparator.comparing(Word::getWordName))
                .collect(Collectors.toList());

        // Serialize list of words
        SerializeDictionary.serialize(wordsToExport, language);
    }
}
