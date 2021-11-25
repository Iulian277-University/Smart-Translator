package entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Word {
    /** Attributes */
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

    public String getWord_en() {
        return word_en;
    }

    public ArrayList<Definition> getDefinitions() {
        return definitions;
    }

    /** Setters */

}
