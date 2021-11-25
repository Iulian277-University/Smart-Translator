package json_deserialization;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import common.Constants;
import entities.Word;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** This is a handler class used for converting json-dictionaries into objects */
public class DeserializeDictionaries {
    private DeserializeDictionaries() {}

    public static List<String> findFiles(Path path, String fileExtension)
            throws IOException {

        if (!Files.isDirectory(path)) {
            throw new IllegalArgumentException("Path must be a directory!");
        }

        List<String> result;

        try (Stream<Path> walk = Files.walk(path)) {
            result = walk
                    .filter(p -> !Files.isDirectory(p))
                    .map(p -> p.toString().toLowerCase())
                    .filter(f -> f.endsWith(fileExtension))
                    .collect(Collectors.toList());
        }

        return result;
    }

    // Map<Language_Name, List_Of_Words>
    private static Map<String, ArrayList<Word>> words = new HashMap<>();
//    private static List<Word> wordsAsList = new ArrayList<>();

    public static void deserialize() throws IOException {
        List<String> inputFiles;
        inputFiles = findFiles(Paths.get(Constants.DICTIONARIES_DIRECTORY), "json");

        Type type = new TypeToken<List<Word>>(){}.getType();
        Gson gson = new Gson();
        for(String inputFile: inputFiles) {
            JsonReader reader = new JsonReader(
                    new FileReader(Constants.DICTIONARIES_DIRECTORY + inputFile));

            // Append to hashmap based on language - dict json fromat: XX_dict.json
            // XX = "ro", "fr", etc...


//            wordsAsList = gson.fromJson(reader, type);
//            for(Word word: wordsAsList) {
//                // Check word language and add id to the hashmap
//                String wordLanguage = word.getLanguage();
//                // If it doesn't exist a hashmap for this language, create it
//                // Otherwise, append to the existing hashmap
//
//            }

        }


    }

}
