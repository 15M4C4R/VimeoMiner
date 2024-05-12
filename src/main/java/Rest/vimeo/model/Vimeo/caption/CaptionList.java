package Rest.vimeo.model.Vimeo.caption;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class CaptionList {

    @JsonProperty("data")
    private List<CaptionVimeo> data;

    public List<CaptionVimeo> getData() { return data;}

    public void setData(List<CaptionVimeo> data) { this.data = data;}

}
