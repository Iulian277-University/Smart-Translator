package utils;

import actions.AddWord;
import common.Constants;
import entities.Word;
import json_deserialization.DeserializeDictionaries;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public final class Database {
    private Database() {}

    public static void loadDatabase() throws IOException {
        Map<String, ArrayList<Word>> wordsMap = DeserializeDictionaries.getMapOfWords();

        // RO <-> EN <-> FR Database
        String englishDatabase = Constants.MOST_COMMON_WORDS_EN;
        String romanianDatabase = Constants.MOST_COMMON_WORDS_RO;
        String frenchDatabase = Constants.MOST_COMMON_WORDS_FR;

        BufferedReader enBr = new BufferedReader(new FileReader(englishDatabase));
        BufferedReader roBr = new BufferedReader(new FileReader(romanianDatabase));
        BufferedReader frBr = new BufferedReader(new FileReader(frenchDatabase));

        while(true) {
            String enWord = enBr.readLine();
            String roWord = roBr.readLine();
            String frWord = frBr.readLine();

            if(enWord == null || roWord == null || frWord == null) {
                break;
            }

            AddWord.addWord(new Word(roWord.toLowerCase(), enWord.toLowerCase()), "ro");
            AddWord.addWord(new Word(frWord.toLowerCase(), enWord.toLowerCase()), "fr");
        }
    }

}
