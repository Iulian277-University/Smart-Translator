package main.testcases;

import actions.TranslateSentenceSynonyms;

import java.util.ArrayList;

public final class TestTranslateSentenceSynonyms {
    private TestTranslateSentenceSynonyms() {}

    public static void testTranslateSentenceSynonyms() {
        String sentence = "+chat *! jeu,  ?manger";

        ArrayList<String> translatedSentences =
                TranslateSentenceSynonyms.translateSentence(sentence, "fr", "ro");

        if(!translatedSentences.isEmpty()) {
            for (String translatedSentence : translatedSentences) {
                System.out.println(translatedSentence);
            }
        }
    }
}
