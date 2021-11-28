package json_deserialization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import common.Constants;
import entities.Word;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** This is a handler class used for converting json-dictionaries into objects */
public final class DeserializeDictionaries {
    private DeserializeDictionaries() {}

    /**
     * Get a list of file-paths as a string list
     * @param path of the directory where the files are located
     * @param fileExtension for selecting only those files
     * @return a list of file-paths as strings
     */
    public static List<String> findFiles(Path path, String fileExtension) {

        if (!Files.isDirectory(path)) {
            System.out.println("Path must be a valid directory! (Create dir if isn't)");
        }

        List<String> result = null;
        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith(fileExtension))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    // Map<Language_Name, List_Of_Words>
    private static final Map<String, ArrayList<Word>> wordsMap = new HashMap<>();

    /**
     * Convert json files into class models, using GSON library
     * https://github.com/google/gson
     */
    public static void deserialize() {
        List<String> inputFiles;
        try {
            inputFiles = findFiles(Paths.get(Constants.DICTIONARIES_INPUT_DIRECTORY), Constants.JSON_EXTENSION);
            if(inputFiles == null || inputFiles.isEmpty()) {
                System.out.println("No json files found in the directory '" + Constants.DICTIONARIES_INPUT_DIRECTORY + "'");
                return;
            }

            Type type = new TypeToken<List<Word>>(){}.getType();
            Gson gson = new Gson();
            for(String inputFilePath: inputFiles) {

                // Check file format
                String inputFilename = inputFilePath.split(Pattern.quote("\\"))[1];
                if((inputFilename.chars().filter(ch -> ch == '_').count() > 1) ||
                        (!inputFilename.matches(Constants.JSON_FILENAME_PATTERN))) {
                    System.out.println("File " + inputFilename + " doesn't match the format '" + Constants.JSON_FILENAME_FORMAT + "'");
                    continue;
                }

                JsonReader reader = new JsonReader(new FileReader(inputFilePath));

                // Append to hashmap based on language - dict json format: XX_dict.json (XX = "ro", "fr", ...)
                String dictLanguage = inputFilename.split(Constants.JSON_LANGUAGE_DELIMITER)[0];

                // If we have fr_dict1.json, fr_dict2.json, ... -> Append the words to the database
                if (wordsMap.containsKey(dictLanguage)) {
                    wordsMap.get(dictLanguage).addAll(gson.fromJson(reader, type));
                } else {
                    wordsMap.put(dictLanguage, gson.fromJson(reader, type));
                }
            }
            System.out.println("-> Imported successfully <-");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Return the map created previously by 'deserialize' method
     */
    public static Map<String, ArrayList<Word>> getMapOfWords() {
        return wordsMap;
    }

}
