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
    private static final Map<String, ArrayList<Word>> wordsMap = new HashMap<>();

    public static void deserialize() throws IOException {
        List<String> inputFiles = null;
        inputFiles = findFiles(Paths.get(Constants.DICTIONARIES_INPUT_DIRECTORY), Constants.JSON_EXTENSION);


        Type type = new TypeToken<List<Word>>(){}.getType();
        Gson gson = new Gson();
        for(String inputFile: inputFiles) {
            JsonReader reader = new JsonReader(new FileReader(inputFile));

            // Append to hashmap based on language - dict json format: XX_dict.json (XX = "ro", "fr", ...)
            String dictLanguage = inputFile.split("_")[0].split(Pattern.quote("\\"))[1];
            wordsMap.put(dictLanguage, gson.fromJson(reader, type));
        }
    }

    public static Map<String, ArrayList<Word>> getMapOfWords() {
        return wordsMap;
    }

}
