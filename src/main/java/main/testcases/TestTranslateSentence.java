package main.testcases;

import actions.TranslateSentence;
import common.Constants;

/** This is a class used for testing the TranslateSentence action */
public final class TestTranslateSentence {
    private TestTranslateSentence() {}

    public static void testTranslateSentence() {
        System.out.println("--- TranslateSentence - Testcase (1) ---");
        String sentence = " Salut! vremea ... de aZi #este !foart frumos";
        String translatedSentence =
                TranslateSentence.translateSentence(sentence, Constants.ROMANIAN_LANGUAGE, Constants.FRENCH_LANGUAGE);
        System.out.println(sentence + " -> " + translatedSentence);

        System.out.println("--- TranslateWord - Testcase (2) ---");
        sentence = " salut.. es-tu heureux?";
        translatedSentence =
                TranslateSentence.translateSentence(sentence, Constants.FRENCH_LANGUAGE, Constants.ROMANIAN_LANGUAGE);
        System.out.println(sentence + " -> " + translatedSentence);
        System.out.println();
    }
}
