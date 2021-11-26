package json_serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import common.Constants;
import entities.Word;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public final class SerializeDictionary {
    private SerializeDictionary() {}

    public static void serialize(List<Word> wordsToSerialize, String language) throws IOException {
        // Generate a unique number for saving the dictionaries (as json files)
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
        String dateTime = dateFormat.format(currentDate);

        // Output filename
        String fileName = language + "_" + "dict" + dateTime + ".json";

        // Export to json
        // Enable pretty-print for json indentation
        // Disable html-escaping for displaying single quotes in output file (by default displays in unicode)
        Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

        Writer writer = Files.newBufferedWriter(Paths.get(Constants.DICTIONARIES_OUTPUT_DIRECTORY + fileName));
        gson.toJson(wordsToSerialize, writer);
        writer.close();
    }
}
