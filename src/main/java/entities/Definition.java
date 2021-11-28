package entities;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/** This is a class used for modeling a Definition class */
public class Definition {
    /**  Attributes */
    @SerializedName("dict")
    private String dict;

    @SerializedName("dictType")
    private String dictType;

    @SerializedName("year")
    private Integer year;

    @SerializedName("text")
    private List<String> text;

    /**  Constructors */
    public Definition(String dict, String dictType, Integer year, List<String> text) {
        this.dict = dict;
        this.dictType = dictType;
        this.year = year;
        this.text = text;
    }

    /**  Getters */
    public String getDict() {
        return dict;
    }

    public String getDictType() {
        return dictType;
    }

    public Integer getYear() {
        return year;
    }

    public List<String> getText() {
        return text;
    }


    /** Public methods */
    @Override
    public String toString() {
        return "Definition{" +
                "dict='" + dict + '\'' +
                ", dictType='" + dictType + '\'' +
                ", year=" + year +
                '}';
    }
}
