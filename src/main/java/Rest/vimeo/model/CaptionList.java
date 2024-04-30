package Rest.vimeo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class CaptionList {

    @JsonProperty("data")
    private List<Caption> data;

    public List<Caption> getData() { return data;}

    public void setData(List<Caption> data) { this.data = data;}

}
