package Rest.vimeo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    @JsonProperty("uri")
    private String uri;
    private String id = List.of(uri.split("/")).get(-1);

    @JsonProperty("text")
    private String text;

    @JsonProperty("created_on")
    private String created_on;

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("created_on")
    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getId() {
        return id;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("created_on")
    public String getCreated_on() {
        return created_on;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", created_on='" + created_on + '\'' +
                '}';
    }


}