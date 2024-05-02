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

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    CommentService commentService;

    @Autowired
    CaptionService captionService;

    private final String token = "81b11cb93a69116057336e2958a4566b";

    public List<Video> findVideosChannel(String id){
        List<Video> videos;
        String uri = "https://api.vimeo.com/channels/"+id+"/videos?page=1&per_page=10";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<VideoList> request = new HttpEntity<>(null, headers);
        ResponseEntity<VideoList> response =
                restTemplate.exchange(uri, HttpMethod.GET,request,VideoList.class);
        videos = response.getBody().getData();
        List<Video> videos1 = new ArrayList<>();
        for(Video v: videos){
            v.setCaptions(captionService.findCaptionsVideo(v.getId()));
            v.setComments(commentService.findAllComments(v.getId()));
            videos1.add(v);
        }
        return videos1;
    }

    /*public Video findOne(String idChannel, String idVideo){
        String uri = "https://api.vimeo.com/channels/"+idChannel+"/videos/"+idVideo;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<Video> request = new HttpEntity<>(null, headers);
        ResponseEntity<Video> response =
                restTemplate.exchange(uri, HttpMethod.GET,request,Video.class);
        return response.getBody();
    }*/

    /*public void setOne(String id, Video video){
        String uri = "https://api.vimeo.com/channels/"+id+"/videos/"+video.getId();//uri de video miner
        HttpEntity<Video> request = new HttpEntity<>(video);
        restTemplate.exchange(uri, HttpMethod.PUT,request,Video.class);
    }*/

}
