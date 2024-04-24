package Rest.Client.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comment {md
    @JsonProperty("uri")
    private String uri;

    @JsonProperty("text")
}
