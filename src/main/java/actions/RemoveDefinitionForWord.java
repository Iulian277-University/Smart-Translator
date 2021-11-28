package actions;

import entities.Definition;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.FilterEntities;

import java.util.ArrayList;
import java.util.Map;

public final class RemoveDefinitionForWord {
    private RemoveDefinitionForWord() {}

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    public static boolean removeDefinition(String word, String language, String dictionary) {
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

        // Iterate through the definitions list of the filteredWord
        ArrayList<Definition> filteredWordDefinitions = filteredWord.getDefinitions();
        ArrayList<Definition> definitionsAfterRemove = new ArrayList<>();
        boolean deletedDefinition = false;
        if(filteredWordDefinitions != null) {
            for (Definition definition : filteredWordDefinitions) {
                if (definition.getDict().equals(dictionary)) {
                    deletedDefinition = true;
                } else {
                    definitionsAfterRemove.add(definition);
                }
            }
        }

        if(deletedDefinition) {
            filteredWord.setDefinitions(definitionsAfterRemove);
            System.out.println("The definitions for word '" + filteredWord.getWord() + "' were successfully removed");
            return true;
        }

        // No definitions from 'dictionary'
        System.out.println("Word '" + word + "' doesn't have definitions from dictionary '" + dictionary + "'");
        return false;
    }

}
