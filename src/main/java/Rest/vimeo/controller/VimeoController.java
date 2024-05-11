package Rest.vimeo.controller;

import Rest.vimeo.model.channel.Channel;
import Rest.vimeo.service.ChannelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
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



    @Operation(
            description = "Get a channel by specifying its id",
            tags = {"channel", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Channel.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema())})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Channel getChannel(@PathVariable String id,
                              @RequestParam(required = false,defaultValue = "10") int maxVideos,
                              @RequestParam(required = false,defaultValue = "10") int maxComments) {
        return service.findOne(id);
    }





    @Operation(
            description = "Create a channel",
            tags = {"channel", "post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = Channel.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema())})
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public Channel sendChannel(@PathVariable String id){
        Channel canal = service.findOne(id);
        HttpEntity<Channel> request = new HttpEntity<>(canal);
        ResponseEntity<Channel> response = restTemplate.exchange(videoMinerUri, HttpMethod.POST,request, Channel.class);
        return response.getBody();
    }
}