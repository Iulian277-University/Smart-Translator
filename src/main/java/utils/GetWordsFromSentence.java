package utils;

import java.text.BreakIterator;
import java.util.ArrayList;

public final class GetWordsFromSentence {
    private GetWordsFromSentence() {}

    public static ArrayList<String> getWordsFromSentence(String sentence) {
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
