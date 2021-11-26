package actions;

import common.Constants;
import entities.Definition;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import utils.FilterEntities;
import utils.GetWordsFromSentence;

import java.util.ArrayList;
import java.util.Map;

public final class TranslateSentenceSynonyms {
    private TranslateSentenceSynonyms() {}

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    private static ArrayList<String> getSynonymsforWord(Word word) {
        // List of synonyms
        ArrayList<String> synonyms = new ArrayList<>();

        ArrayList<Definition> definitions = word.getDefinitions();
        for(Definition definition: definitions) {
            if(definition.getDictType().equals(Constants.DEFINITION_SYNONYMS)) {
                synonyms.addAll(definition.getText());
            }
        }

        return synonyms;
    }

    public static ArrayList<String> translateSentence(String sentence, String fromLanguage, String toLanguage) {
        // Returned translated-sentences
        ArrayList<String> translatedSentences = new ArrayList<>();

        ArrayList<String> words = GetWordsFromSentence.getWordsFromSentence(sentence);

        for(int i = 0; i < Constants.TRANSLATION_ALTERNATIVES; ++i) {
            StringBuilder translatedSentence = new StringBuilder();
            for(String word: words) {
                String translatedWord = TranslateWord.translateWord(word, fromLanguage, toLanguage);
                if(translatedWord == null) {
                    translatedSentence.append("(").append(word).append(" not found) ");
                } else {
                    Word translatedWordObject = FilterEntities.filterWordsByName(wordsMap.get(toLanguage), translatedWord);
                    ArrayList<String> wordSynonyms = getSynonymsforWord(translatedWordObject);

                    String synonymUsed;
                    if(wordSynonyms.isEmpty()) {
                        synonymUsed = translatedWordObject.getWord();
                        translatedSentence.append(synonymUsed).append(" ");
                        continue;
                    }

                    // Prevent 'overflow'
                    synonymUsed = wordSynonyms.get(i % wordSynonyms.size());
                    translatedSentence.append(synonymUsed).append(" ");
                }
            }
            translatedSentences.add(translatedSentence.toString());
        }

        return translatedSentences;
    }

}
