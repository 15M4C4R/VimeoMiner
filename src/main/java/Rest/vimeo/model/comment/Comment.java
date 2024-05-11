package Rest.vimeo.model.comment;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {
    @JsonProperty("uri")
    private String uri;
    private String id ;

    @JsonProperty("text")
    private String text;

    @JsonProperty("createdOn")
    private String created_on;

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("createdOn")
    public void setCreated_on(String created_on) {
        this.created_on = created_on;
    }

    public String getId() {
        List<String> partes = List.of(uri.split("/"));
        return partes.get(partes.size()-1);
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("createdOn")
    public String getCreated_on() {
        return created_on;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", createdOn='" + created_on + '\'' +
                '}';
    }


}
