package entities;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Definition {
    /**  Attributes */
    @SerializedName("dict")
    private String dict;

    @SerializedName("dictType")
    private String dictType;

    @SerializedName("year")
    private Integer year;

    @SerializedName("text")
    private ArrayList<String> text;

    /**  Constructors */

    /**  Getters */
    public String getDict() {
        return dict;
    }
    /**  Setters */

}
