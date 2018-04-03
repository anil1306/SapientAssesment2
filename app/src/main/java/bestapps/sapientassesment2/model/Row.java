package bestapps.sapientassesment2.model;

/**
 * Created by Anil on 4/3/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Row implements Serializable
{

    private final static long serialVersionUID = -6298275283366994370L;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("imageHref")
    @Expose
    private Object imageHref;

    /**
     * No args constructor for use in serialization
     *
     */
    public Row() {
    }
    /**
     *
     * @param title : get Title from the json
     * @param description : get Description from JSON
     * @param imageHref : get image URL from JSON
     */
    public Row(String title, String description, Object imageHref) {
        super();
        this.title = title;
        this.description = description;
        this.imageHref = imageHref;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getImageHref() {
        return imageHref;
    }

    public void setImageHref(Object imageHref) {
        this.imageHref = imageHref;
    }

}
