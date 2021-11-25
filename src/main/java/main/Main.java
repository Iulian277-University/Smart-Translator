package main;

import entities.Word;
import json_deserialization.DeserializeDictionaries;

import java.util.ArrayList;
import java.util.Map;

/** This is class is the entry point of the program */
public class Main {
    public static void main(String[] args) {

        // Deserialize json into class models
        DeserializeDictionaries.deserialize();

        // Map<Language_Name, List_Of_Words>
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

    }
}
