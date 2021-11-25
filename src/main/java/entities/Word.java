package entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Word {
    /** Attributes */
    @SerializedName("language")
    private String language;

    @SerializedName("word")
    private String word;

    @SerializedName("word_en")
    private String word_en;

    @SerializedName("type")
    private String type;

    @SerializedName("singular")
    private ArrayList<String> singular;

    @SerializedName("plural")
    private ArrayList<String> plural;

    @SerializedName("definitions")
    private ArrayList<Definition> definitions;

    /** Constructors */


    /** Getters */
    public String getWord() {
        return word;
    }

    public String getLanguage() {
        return language;
    }

    public ArrayList<Definition> getDefinitions() {
        return definitions;
    }

    /** Setters */

}
