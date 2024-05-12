
package Rest.vimeo.model.Vimeo.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class UserVimeo {

    @JsonProperty("uri")
    private String uri;
    @JsonProperty("name")
    private String name;
    @JsonProperty("link")
    private String user_link;
    //private String user_link = getLink();
    @JsonProperty("pictures")
    private Pictures pictures;

    private String picture_link;

    private Long id;

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("link")
    public String getLink() {
        return user_link;
    }

    @JsonProperty("link")
    public void setLink(String link) {
        this.user_link = link;
    }

    @JsonProperty("pictures")
    public Pictures getPictures() {
        return pictures;
    }

    @JsonProperty("pictures")
    public void setPictures(Pictures pictures) {
        this.pictures = pictures;
    }

    public Long getId() {
        return Long.valueOf(this.getUri().replace("/users/", ""));
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPicture_link() {
        return pictures.getBaseLink();
    }

    public void setPicture_link(String picture_link) {
        this.picture_link = picture_link;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(UserVimeo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("link");
        sb.append('=');
        sb.append(((this.user_link == null)?"<null>":this.user_link));
        sb.append(',');
        sb.append("pictures");
        sb.append('=');
        sb.append(((this.pictures == null)?"<null>":this.pictures));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
