package main.testcases;

import actions.RemoveWord;
import common.Constants;

/** This is a class used for testing the RemoveWord action */
public final class TestRemoveWord {
    private TestRemoveWord() {}

    public static void testRemoveWord() {
        System.out.println("--- RemoveWord - Testcase (1) ---");
        RemoveWord.removeWord("bonjour", Constants.FRENCH_LANGUAGE);

        System.out.println("--- RemoveWord - Testcase (2) ---");
        RemoveWord.removeWord("bonjour", Constants.FRENCH_LANGUAGE);
        System.out.println();
    }
}
