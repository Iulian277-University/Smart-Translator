package main;

import json_deserialization.DeserializeDictionaries;
import utils.Database;

/** This class is the entry point of the program */
public class Main {
    public static void main(String[] args){
        // Deserialize json dictionaries into class models
        System.out.println("----- IMPORTING INPUT DICTIONARIES -----");
        DeserializeDictionaries.deserialize();
        System.out.println("----- END IMPORTING INPUT DICTIONARIES -----\n");

        /**
        @Create-the-database:
        @v1: Google-Translate-API: Produces error 429 (too many requests)
        @v2: Selenium Python Script is too slow (~1 word/sec) (https://github.com/Iulian277/Google-Translate-Web-Scrapping)
        @v3: Alternative: Use a small database (ro <-> en <-> fr) (~3k words)
         */

        // Import the database with 3k words
        System.out.println("----- IMPORTING DATABASE -----");
        Database.loadDatabase();
        System.out.println("----- END IMPORTING DATABASE -----\n");


        // Run testcases
        System.out.println("----- STARTING TESTCASES -----");
        Test.runTestcases();
        System.out.println("----- ENDING TESTCASES -----");
    }
}
