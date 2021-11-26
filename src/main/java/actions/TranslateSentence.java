package actions;

import java.util.ArrayList;

public final class TranslateSentence {
    private TranslateSentence() {}

    public static String translateSentence(String sentence, String fromLanguage, String toLanguage) {
        // Split sentence in words, deleting the punctuation
        String[] words = sentence.split("[\\p{Punct}\\s]+");

        StringBuilder translatedSentence = new StringBuilder();
        for(String word: words) {
            String translatedWord = TranslateWord.translateWord(word, fromLanguage, toLanguage);
            if(translatedWord == null) {
                // return translatedSentence.toString();
                translatedSentence.append("(").append(word).append(" not found) ");
            } else {
                translatedSentence.append(translatedWord).append(" ");
            }
        }

        // Return the sentence-translation
        return translatedSentence.toString();
    }

}
