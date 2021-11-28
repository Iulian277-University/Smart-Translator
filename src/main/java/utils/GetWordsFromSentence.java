package utils;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

/** This is a handler class for tokenization a sentence into words */
public final class GetWordsFromSentence {
    private GetWordsFromSentence() {}

    /**
     * Split the sentence in words, deleting the punctuation and symbols
     * @param sentence as a string
     * @return the words from the sentence (as a list)
     */
    public static List<String> getWordsFromSentence(String sentence) {
        ArrayList<String> words = new ArrayList<>();

        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(sentence);
        int lastIndex = breakIterator.first();

        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(sentence.charAt(firstIndex))) {
                words.add(sentence.substring(firstIndex, lastIndex));
            }
        }

        return words;
    }
}
