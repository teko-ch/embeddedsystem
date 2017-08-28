package ch.teko.restexample.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jonathan on 28.08.17.
 */

public class Repository {
    public int id;
    public String name;
    @SerializedName("full_name")
    public String fullName;
    @SerializedName("html_url")
    public String htmlUrl;
    public String description;

    public Repository(int id, String name, String htmlUrl, String description) {
        this.id = id;
        this.name = name;
        this.htmlUrl = htmlUrl;
        this.description = description;
    }


}
