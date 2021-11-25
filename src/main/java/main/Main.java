package main;

import com.google.gson.Gson;
import json_deserialization.DeserializeDictionaries;

import java.io.FileNotFoundException;
import java.io.IOException;

/** This is class is the entry point of the program */
public class Main {
    public static void main(String[] args) throws IOException {

        // Process all input-dictionary files
        System.out.println("Starting...");

        // Deserialize json into class models
        DeserializeDictionaries.deserialize();

    }
}
