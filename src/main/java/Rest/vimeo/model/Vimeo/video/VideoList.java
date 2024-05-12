package Rest.vimeo.model.Vimeo.video;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class VideoList {

    @JsonProperty("data")
    private List<VideoVimeo> data;

    public List<VideoVimeo> getData() {
        return data;
    }

    public void setData(List<VideoVimeo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "VideoList{" +
                "data=" + data +
                '}';
    }
}
