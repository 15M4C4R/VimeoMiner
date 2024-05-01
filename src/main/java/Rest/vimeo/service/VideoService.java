package Rest.vimeo.service;

import Rest.vimeo.model.video.Video;
import Rest.vimeo.model.video.VideoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;

    private final String token = "81b11cb93a69116057336e2958a4566b";

    public List<Video> findVideosChannel(String id){
        String uri = "https://api.vimeo.com/channels/"+id+"/videos";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<VideoList> request = new HttpEntity<>(null, headers);
        ResponseEntity<VideoList> response =
                restTemplate.exchange(uri, HttpMethod.GET,request,VideoList.class);
        return response.getBody().getData();
    }

    public Video findOne(String idChannel, String idVideo){
        String uri = "https://api.vimeo.com/channels/"+idChannel+"/videos/"+idVideo;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<Video> request = new HttpEntity<>(null, headers);
        ResponseEntity<Video> response =
                restTemplate.exchange(uri, HttpMethod.GET,request,Video.class);
        return response.getBody();
    }

    public void setOne(String id, Video video){
        String uri = "https://api.vimeo.com/channels/"+id+"/videos/"+video.getId();//uri de video miner
        HttpEntity<Video> request = new HttpEntity<>(video);
        restTemplate.exchange(uri, HttpMethod.PUT,request,Video.class);
    }

}
