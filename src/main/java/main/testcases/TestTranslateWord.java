package main.testcases;

import actions.TranslateWord;
import common.Constants;

/** This is a class used for testing the TranslateWord action */
public final class TestTranslateWord {
    private TestTranslateWord() {}

    public static void testTranslateWord() {
        System.out.println("--- TranslateWord - Testcase (1) ---");
        String word = "chat";
        String fromLanguage = Constants.FRENCH_LANGUAGE;
        String toLanguage = Constants.ROMANIAN_LANGUAGE;

        String translatedWord = TranslateWord.translateWordWithFeedback(word, fromLanguage, toLanguage);
        if(translatedWord != null) {
            System.out.println(fromLanguage + ":" + word + " -> " + toLanguage + ":" + translatedWord);
        }


        System.out.println("--- TranslateWord - Testcase (2) ---");
        word = "hello";
        fromLanguage = Constants.ENGLISH_LANGUAGE;
        toLanguage = Constants.ROMANIAN_LANGUAGE;

        translatedWord = TranslateWord.translateWordWithFeedback(word, fromLanguage, toLanguage);
        if(translatedWord != null) {
            System.out.println(fromLanguage + ":" + word + " -> " + toLanguage + ":" + translatedWord);
        }


        System.out.println("--- TranslateWord - Testcase (3) ---");
        word = "cha";
        fromLanguage = Constants.FRENCH_LANGUAGE;
        toLanguage = Constants.ROMANIAN_LANGUAGE;

        translatedWord = TranslateWord.translateWordWithFeedback(word, fromLanguage, toLanguage);
        if(translatedWord != null) {
            System.out.println(fromLanguage + ":" + word + " -> " + toLanguage + ":" + translatedWord);
        }
        System.out.println();
    }
}
