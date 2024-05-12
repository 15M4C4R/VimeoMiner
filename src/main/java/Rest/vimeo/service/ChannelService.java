package Rest.vimeo.service;

import Rest.vimeo.model.Vimeo.channel.ChannelVimeo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service

public class ChannelService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    VideoService videoService;

    private String token = "81b11cb93a69116057336e2958a4566b";

    public ChannelVimeo findOne(String id, int maxVideos, int maxComments){
        ChannelVimeo channel = null;
        String uri = "https://api.vimeo.com/channels/"+id;
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<ChannelVimeo> request = new HttpEntity<>(null, headers);
        ResponseEntity<ChannelVimeo> response =
                restTemplate.exchange(uri, HttpMethod.GET,request, ChannelVimeo.class);
        channel = response.getBody();
        channel.setVideos(videoService.findVideosChannel(channel.getId(), maxVideos, maxComments));
        return channel;
    }

    public void setOne(ChannelVimeo channel){
        String uri = "https://api.vimeo.com/channels/"+channel.getId(); //Esta uri tiene que se la de video miner
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer "+this.token);
        HttpEntity<ChannelVimeo> request = new HttpEntity<>(channel, headers);
        ResponseEntity<ChannelVimeo> response =
                restTemplate.exchange(uri, HttpMethod.PUT,request, ChannelVimeo.class);
    }

}
