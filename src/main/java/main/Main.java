package main;

import common.Constants;
import entities.Word;
import json_deserialization.DeserializeDictionaries;
import main.testcases.TestExportDictionary;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

import actions.*;
import utils.Database;

/** This class is the entry point of the program */
public class Main {
    public static void main(String[] args){
        // Deserialize json into class models
         DeserializeDictionaries.deserialize();

        // Run testcases
        // Test.runTestcases();

        // Google-Translate-API: Produces error 429 (too many requests) :(
        // https://github.com/goxr3plus/java-google-speech-api
        // Alternative: Use a small database (ro <-> en <-> fr) (~3k words)
        try {
            Database.loadDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(TranslateWord.translateWord("ieri", "ro", "fr"));
    }
}
