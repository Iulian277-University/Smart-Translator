package main.testcases;

import actions.TranslateSentence;

public final class TestTranslateSentence {
    private TestTranslateSentence() {}

    public static void testTranslateSentence() {
        String sentence = "chat jeu, manger";
        String translatedSentence = TranslateSentence.translateSentence(sentence, "fr", "ro");
        System.out.println(translatedSentence);
    }

}
