package main.testcases;

import actions.GetDefinitionsForWord;
import entities.Definition;

import java.util.ArrayList;

public final class TestGetDefinitionsForWord {
    private TestGetDefinitionsForWord() {}

    public static void testGetDefinitionsForWord() {
        ArrayList<Definition> definitions = GetDefinitionsForWord.getDefinitionsForWord("câine", "ro");
        if(!definitions.isEmpty()) {
            for (Definition definition: definitions) {
                System.out.println(definition);
            }
        }
    }

}
