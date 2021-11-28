package common;

/** This is a handler class for holding constants used in the program */
public final class Constants {
    private Constants() {}

    // CUSTOMIZABLE PARAMETERS
    public static final String DICTIONARIES_INPUT_DIRECTORY = "dictionaries-input/";
    public static final String DICTIONARIES_OUTPUT_DIRECTORY = "dictionaries-output/";

    public static final String DEFINITION_SYNONYMS = "synonyms";
    public static final String DEFINITION_DEFINITIONS = "definitions";

    public static final Integer TRANSLATION_ALTERNATIVES = 3;

    public static final String ENGLISH_LANGUAGE = "en";
    public static final String FRENCH_LANGUAGE = "fr";
    public static final String ROMANIAN_LANGUAGE = "ro";

    // END CUSTOMIZABLE PARAMETERS


    // DO NOT MODIFY
    public static final String JSON_EXTENSION = "json";
    public static final String JSON_LANGUAGE_DELIMITER = "_";
    public static final String JSON_FILENAME_PATTERN = ".*[_].*.json";
    public static final String JSON_FILENAME_FORMAT = "language_dictName.json";

    public static final String DATE_FORMAT = "yyMMddhhmmssMs";

    public static final String MOST_COMMON_WORDS_EN = "database/db_en.txt";
    public static final String MOST_COMMON_WORDS_RO = "database/db_ro.txt";
    public static final String MOST_COMMON_WORDS_FR = "database/db_fr.txt";

    // END DO NOT MODIFY

}
