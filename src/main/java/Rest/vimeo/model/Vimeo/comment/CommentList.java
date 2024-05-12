package Rest.vimeo.model.Vimeo.comment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)


public class CommentList {

    @JsonProperty("data")
    private List<CommentVimeo> data;

    public List<CommentVimeo> getData() {
        return data;
    }

    public void setData(List<CommentVimeo> data) {
        this.data = data;
    }

}
