package actions;

import entities.Definition;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.FilterEntities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** This is a class used for appending a definition for a given word */
public final class AddDefinitionForWord {
    private AddDefinitionForWord() {}

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    /**
     * Add a definition for a given word
     * @param word 'word_name' as a string
     * @param language of the word as a string
     * @param definition to be added on the word
     * @return the status of the action (true - added successfully; false - couldn't add the definition)
     */
    public static boolean addDefinitionForWord(String word, String language, Definition definition) {
        // The dictionary in 'language' doesn't exist
        ArrayList<Word> languageWords = wordsMap.get(language);
        if(languageWords == null) {
            System.out.println("The dictionary in language '" + language + "' doesn't exist");
            return false;
        }

        // The word isn't in the dictionary
        Word filteredWord = FilterEntities.filterWordsByName(languageWords, word);
        if(filteredWord == null) {
            System.out.println("The word '" + word + "' isn't in the dictionary");
            return false;
        }

        // Already exist a definition from the same dict ("dict": "Larousse")
        List<Definition> filteredWordDefinitions = filteredWord.getDefinitions();
        for(Definition currentDefinition: filteredWordDefinitions) {
            if(currentDefinition.getDict().equals(definition.getDict())) {
                System.out.println("Already exist a definition from dictionary '" + definition.getDict() + "'");
                return false;
            }
        }

        // Otherwise, add the definition to the list
        filteredWord.getDefinitions().add(definition);
        System.out.println("The definition for word '" + filteredWord.getWordName() + "' was successfully added");
        return true;
    }
}
