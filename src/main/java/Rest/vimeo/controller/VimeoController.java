package Rest.vimeo.controller;

import Rest.vimeo.model.channel.Channel;
import Rest.vimeo.service.ChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/vimeominer")
public class VimeoController {
    @Autowired
    ChannelService service;
    @Autowired
    RestTemplate restTemplate;
    final String videoMinerUri = "http://localhost:8080/api/videoMiner/videos";
    @GetMapping("/{id}")
    public Channel getChannel(@PathVariable String id,
                              @RequestParam(required = false,defaultValue = "10") int maxVideos,
                              @RequestParam(required = false,defaultValue = "10") int maxComments) {
        return service.findOne(id);
    }
    @PostMapping("/{id}")
    public Channel sendChannel(@PathVariable String id){
        Channel canal = service.findOne(id);
        HttpEntity<Channel> request = new HttpEntity<>(canal);
        ResponseEntity<Channel> response = restTemplate.exchange(videoMinerUri, HttpMethod.POST,request, Channel.class);
        return response.getBody();
    }
}