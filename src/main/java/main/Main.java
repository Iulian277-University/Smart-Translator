package main;

import json_deserialization.DeserializeDictionaries;
import main.testcases.*;

import java.io.IOException;

/** This class is the entry point of the program */
public class Main {
    public static void main(String[] args) {
        // Deserialize json into class models
        DeserializeDictionaries.deserialize();

        // Run testcases
        Test.runTestcases();
    }
}
