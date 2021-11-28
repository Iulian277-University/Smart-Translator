package json_serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import common.Constants;
import entities.Word;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/** This is a class used for serializing a dictionary */
public final class SerializeDictionary {
    private SerializeDictionary() {}

    /**
     * Serialize a dictionary given the list of words and the language
     * @param wordsToSerialize: list of words to be serialized
     * @param language of the dictionary to be serialized
     */
    public static void serialize(List<Word> wordsToSerialize, String language) {
        // Generate a unique number for saving the dictionaries (as json files)
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
        String dateTime = dateFormat.format(currentDate);

        // Output filename
        String fileName = language + "_" + "dict" + dateTime + ".json";

        // Check if output directory is valid
        Path outputDir = Paths.get(Constants.DICTIONARIES_OUTPUT_DIRECTORY);
        if (!Files.isDirectory(outputDir)) {
            try {
                Files.createDirectories(outputDir);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Path must be a valid directory! (Create dir if isn't)");
            }
        }

        // Export to json
        // Enable pretty-print for json indentation
        // Disable html-escaping for displaying single quotes in output file (by default displays in unicode)
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        Path outputFile = Path.of(outputDir + "/" + fileName);
        Writer writer = null;
        try {
            writer = Files.newBufferedWriter(outputFile);
            gson.toJson(wordsToSerialize, writer);
            System.out.println("'" + language + "' dictionary has been exported successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
