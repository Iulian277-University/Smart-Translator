package main.testcases;

import actions.GetDefinitionsForWord;
import common.Constants;
import entities.Definition;

import java.util.ArrayList;

public final class TestGetDefinitionsForWord {
    private TestGetDefinitionsForWord() {}

    public static void testGetDefinitionsForWord() {
        System.out.println("--- GetDefinitionsForWord - Testcase (1) ---");
        ArrayList<Definition> definitions = GetDefinitionsForWord.getDefinitionsForWord("câine", Constants.ROMANIAN_LANGUAGE);
        if(!definitions.isEmpty()) {
            for (Definition definition: definitions) {
                System.out.println(definition);
            }
        }

        System.out.println("--- GetDefinitionsForWord - Testcase (2) ---");
        definitions = GetDefinitionsForWord.getDefinitionsForWord("câine", Constants.FRENCH_LANGUAGE);
        if(!definitions.isEmpty()) {
            for (Definition definition: definitions) {
                System.out.println(definition);
            }
        }
        System.out.println();
    }

}
