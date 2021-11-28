package entities;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/** This is a class used for modeling a Word class */
public class Word {
    /** Attributes */
    @SerializedName("word")
    private String wordName;

    @SerializedName("word_en")
    private String wordEn;

    @SerializedName("type")
    private String type;

    @SerializedName("singular")
    private List<String> singular;

    @SerializedName("plural")
    private List<String> plural;

    @SerializedName("definitions")
    private List<Definition> definitions;


    /** Constructors */
    public Word(String wordName, String wordEn) {
        this.wordName = wordName;
        this.wordEn = wordEn;
    }

    public Word(String word, String wordEn, String type, List<String> singular,
                List<String> plural,List<Definition> definitions) {
        this.wordName = word;
        this.wordEn = wordEn;
        this.type = type;
        this.singular = singular;
        this.plural = plural;
        this.definitions = definitions;
    }

    /** Getters */
    public String getWordName() {
        return wordName;
    }

    public String getWordEn() {
        return wordEn;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }

    /** Public methods */
    @Override
    public String toString() {
        return "Word{" +
                "word='" + wordName + '\'' +
                ", word_en='" + wordEn + '\'' +
                ", type='" + type + '\'' +
                ", singular=" + singular +
                ", plural=" + plural +
                ", definitions=" + definitions +
                '}';
    }
}
