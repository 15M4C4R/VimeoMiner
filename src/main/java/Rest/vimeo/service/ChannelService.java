package Rest.vimeo.service;

import Rest.vimeo.model.Channel;
import Rest.vimeo.model.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import java.util.List;
import java.util.Map;

@Service

public class ChannelService {
    @Autowired
    RestTemplate restTemplate;
    VideoService videoService;

    private String token = "81b11cb93a69116057336e2958a4566b";

    public List<Channel> findAllChannels(){
        String uri = "https://api.vimeo.com/channels?page=1&per_page=10";
        HttpHeaders headers = new HttpHeaders();

    }

    public Channel findOne(String id){
        Channel channel = null;
        String uri = "https://api.vimeo.com/channels/"+id;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<Channel> request = new HttpEntity<>(null, headers);
        ResponseEntity<Channel> response =
                restTemplate.exchange(uri, HttpMethod.GET,request,Channel.class);
        channel = response.getBody();
        return channel;
    }

    public void setOne(Channel channel){
        String uri = "https://api.vimeo.com/channels/"+channel.getId(); //Esta uri tiene que se la de video miner
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<Channel> request = new HttpEntity<>(channel, headers);
        ResponseEntity<Channel> response =
                restTemplate.exchange(uri, HttpMethod.PUT,request,Channel.class);
    }

    public List<Video> getVideos(String id){
        return videoService.findVideosChannel(id);
    }

}