package main.testcases;

import actions.TranslateWord;

public final class TestTranslateWord {
    private TestTranslateWord() {}

    public static void translateWord() {
        String translatedWord = TranslateWord.translateWord("chat", "fr", "ro");
        if(translatedWord != null) {
            System.out.println(translatedWord);
        }
    }

}
