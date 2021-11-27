package main;

import json_deserialization.DeserializeDictionaries;
import main.testcases.*;


/** This class is the entry point of the program */
public class Main {
    public static void main(String[] args) {
        // Deserialize json into class models
        DeserializeDictionaries.deserialize();

        // Run testcases
        Test.runTestcases();

        // TODO: Google-Translate-API - Create dictionaries database
    }
}
