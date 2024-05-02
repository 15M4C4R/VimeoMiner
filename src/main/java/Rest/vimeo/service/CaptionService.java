package Rest.vimeo.service;


import Rest.vimeo.model.caption.Caption;
import Rest.vimeo.model.caption.CaptionList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CaptionService {

    @Autowired
    RestTemplate restTemplate;

    private final String token = "81b11cb93a69116057336e2958a4566b";

    public List<Caption> findCaptionsVideo(String idVideo){
        String uri = "https://api.vimeo.com/videos/"+idVideo+"/texttracks";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<CaptionList> request = new HttpEntity<>(null,headers);
        ResponseEntity<CaptionList> response =
                restTemplate.exchange(uri, HttpMethod.GET,request,CaptionList.class);
        return response.getBody().getData();
    }

}
