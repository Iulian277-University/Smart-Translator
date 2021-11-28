package main.testcases;

import actions.TranslateSentenceSynonyms;
import common.Constants;
import java.util.List;

/** This is a class used for testing the TranslateSentenceSynonyms action */
public final class TestTranslateSentenceSynonyms {
    private TestTranslateSentenceSynonyms() {}

    public static void testTranslateSentenceSynonyms() {
        System.out.println("--- TranslateSentenceSynonyms - Testcase (1) ---");
        String sentence = "+chat *! diplômé,  ?manger ... salut";

        List<String> translatedSentences =
                TranslateSentenceSynonyms.translateSentence(sentence, Constants.FRENCH_LANGUAGE, Constants.ROMANIAN_LANGUAGE);

        if(!translatedSentences.isEmpty()) {
            for (String translatedSentence : translatedSentences) {
                System.out.println(sentence + " -> " + translatedSentence);
            }
        }

        System.out.println("--- TranslateSentenceSynonyms - Testcase (2) ---");
        sentence = "buna!~cum.. te simti ?";

        translatedSentences =
                TranslateSentenceSynonyms.translateSentence(sentence, Constants.ROMANIAN_LANGUAGE, Constants.FRENCH_LANGUAGE);

        if(!translatedSentences.isEmpty()) {
            for (String translatedSentence : translatedSentences) {
                System.out.println(sentence + " -> " + translatedSentence);
            }
        }
        System.out.println();
    }
}
