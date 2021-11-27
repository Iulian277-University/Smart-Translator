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
    public Word(String word, String word_en) {
        this.word = word;
        this.word_en = word_en;
    }

    public Word(String word, String word_en, String type, ArrayList<String> singular,
                ArrayList<String> plural,ArrayList<Definition> definitions) {
        this.word = word;
        this.word_en = word_en;
        this.type = type;
        this.singular = singular;
        this.plural = plural;
        this.definitions = definitions;
    }

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

    public void setDefinitions(ArrayList<Definition> definitions) {
        this.definitions = definitions;
    }

    /** Setters */



    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", word_en='" + word_en + '\'' +
                ", type='" + type + '\'' +
                ", singular=" + singular +
                ", plural=" + plural +
                ", definitions=" + definitions +
                '}';
    }
}
