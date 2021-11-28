package main;

import common.Constants;
import json_deserialization.DeserializeDictionaries;

import java.io.*;

import actions.*;
import utils.Database;

/** This class is the entry point of the program */
public class Main {
    public static void main(String[] args){
        // Deserialize json dictionaries into class models
        System.out.println("----- IMPORTING INPUT DICTIONARIES -----");
        DeserializeDictionaries.deserialize();
        System.out.println("----- END IMPORTING INPUT DICTIONARIES -----");

        /**
        @v1: Google-Translate-API: Produces error 429 (too many requests) (https://github.com/goxr3plus/java-google-speech-api)
        @v2: Selenium Python Script is too slow (~1 word/sec)
        @v3: Alternative: Use a small database (ro <-> en <-> fr) (~3k words)
         */

        // Import 3k words database
        System.out.println("----- IMPORTING DATABASE -----");
        Database.loadDatabase();
        System.out.println("----- END IMPORTING DATABASE -----");

        // Run testcases
        System.out.println("----- STARTING TESTCASES -----");
        Test.runTestcases();
        System.out.println("----- ENDING TESTCASES -----");

        // TODO: Translate to/from english
    }
}
