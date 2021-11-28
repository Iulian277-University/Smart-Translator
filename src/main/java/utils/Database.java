package utils;

import actions.AddWord;
import common.Constants;
import entities.Word;

import java.io.*;

/** This is a handler class for working with a small database (~3k words) */
public final class Database {
    private Database() {}

    /**
     * Read from init-db-files and store the words in the wordsMap
     */
    private static void initDatabase() throws IOException {
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

            AddWord.addWord(new Word(roWord.toLowerCase(), enWord.toLowerCase()), Constants.ROMANIAN_LANGUAGE);
            AddWord.addWord(new Word(frWord.toLowerCase(), enWord.toLowerCase()), Constants.FRENCH_LANGUAGE);
        }
    }

    /**
     * Load the database, by initializing it
     */
    public static void loadDatabase() {
        try {
            // Redirect the output stream
            PrintStream original = System.out;
            System.setOut(new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                    // Redirect the output stream to nothing
                }
            }));

            // Initialize the database
            initDatabase();

            // Redirect the output stream to the original system.out
            System.setOut(original);
            System.out.println("-> Imported successfully <-");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
