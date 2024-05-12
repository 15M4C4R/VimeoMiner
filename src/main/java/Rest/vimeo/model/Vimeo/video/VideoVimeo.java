package Rest.vimeo.model.Vimeo.video;

import java.util.List;

import Rest.vimeo.model.Vimeo.caption.CaptionVimeo;
import Rest.vimeo.model.Vimeo.comment.CommentVimeo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VideoVimeo {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("release_time")
    private String releaseTime;

    private String id;

    public List<CaptionVimeo> getCaptions() {
        return captions;
    }

    public void setCaptions(List<CaptionVimeo> captions) {
        this.captions = captions;
    }

    public void setComments(List<CommentVimeo> comments) {
        this.comments = comments;
    }

    public List<CommentVimeo> getComments() {
        return comments;
    }

    private List<CaptionVimeo> captions;

    private List<CommentVimeo> comments;

    public String getId() {
        List<String> aux = List.of(this.uri.split("/"));
        return aux.get(aux.size()-1);
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("release_time")
    public String getReleaseTime() {
        return releaseTime;
    }

    @JsonProperty("release_time")
    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VideoVimeo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("description");
        sb.append('=');
        sb.append(((this.description == null)?"<null>":this.description));
        sb.append(',');
        sb.append("release_time");
        sb.append('=');
        sb.append(((this.releaseTime == null)?"<null>":this.releaseTime));
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }
}