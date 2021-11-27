package main.testcases;

import actions.TranslateWord;

public final class TestTranslateWord {
    private TestTranslateWord() {}

    public static void testTranslateWord() {
        String word = "chat";
        String fromLanguage = "fr";
        String toLanguage = "ro";

        String translatedWord = TranslateWord.translateWordWithFeedback(word, fromLanguage, toLanguage);
        if(translatedWord != null) {
            System.out.println(fromLanguage + ":" + word + " -> " + toLanguage + ":" + translatedWord);
        }
    }
}
