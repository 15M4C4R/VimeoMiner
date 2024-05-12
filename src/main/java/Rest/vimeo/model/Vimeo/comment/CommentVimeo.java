package Rest.vimeo.model.Vimeo.comment;

import java.util.List;

import Rest.vimeo.model.Video.Video;
import Rest.vimeo.model.Vimeo.user.UserVimeo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentVimeo {
    @JsonProperty("uri")
    private String uri;
    private String id ;

    @JsonProperty("text")
    private String text;

    @JsonProperty("created_on")
    private String createdOn;

    @JsonProperty("user")
    private UserVimeo user;

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("created_on")
    public String getCreatedOn() {
        return createdOn;
    }

    @JsonProperty("created_on")
    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getId() {
        List<String> partes = List.of(uri.split("/"));
        return partes.get(partes.size()-1);
    }

    @JsonProperty("user")
    public UserVimeo getUser(){ return user; }

    @JsonProperty("user")
    public void setUser(UserVimeo user){ this.user = user; }

    @JsonProperty("text")
    public String getText() {
        return text;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", text='" + text + '\'' +
                ", created_on='" + createdOn + '\'' +
                '}';
    }


}
