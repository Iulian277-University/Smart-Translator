package actions;

import utils.GetWordsFromSentence;
import java.util.List;

/** This is a class used for translating a given sentence from a sourceLanguage to a targetLanguage */
public final class TranslateSentence {
    private TranslateSentence() {}

    /**
     * Translate a sentence sourceLanguage to targetLanguage
     * @param sentence 'sentence' as a string
     * @param fromLanguage 'source_language' as a string
     * @param toLanguage 'target_language' as a string
     * @return the translated sentence as a string
     */
    public static String translateSentence(String sentence, String fromLanguage, String toLanguage) {
        if(fromLanguage.isEmpty() || toLanguage.isEmpty()) {
            System.out.println("Non-empty fields required");
            return "";
        }

        // Split sentence in words, deleting the punctuation and symbols
        List<String> words = GetWordsFromSentence.getWordsFromSentence(sentence);
        StringBuilder translatedSentence = new StringBuilder();

        for(String word: words) {
            String translatedWord = TranslateWord.translateWord(word, fromLanguage, toLanguage);
            if(translatedWord == null) {
                translatedSentence.append("(").append(word).append(" not found) ");
            } else {
                translatedSentence.append(translatedWord).append(" ");
            }
        }

        // Return the sentence-translation
        return translatedSentence.toString();
    }
}
