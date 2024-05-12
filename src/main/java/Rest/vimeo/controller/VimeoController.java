package Rest.vimeo.controller;

import Rest.vimeo.Parser.ParserVideoMiner;
import Rest.vimeo.model.Video.*;
import Rest.vimeo.model.Video.Video;
import Rest.vimeo.model.Vimeo.channel.ChannelVimeo;
import Rest.vimeo.model.Vimeo.video.VideoVimeo;
import Rest.vimeo.service.CaptionService;
import Rest.vimeo.service.ChannelService;
import Rest.vimeo.service.CommentService;
import Rest.vimeo.service.VideoService;
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

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/vimeominer")
public class VimeoController {
    @Autowired
    ChannelService channelService;
    @Autowired
    VideoService videoService;
    @Autowired
    CommentService commentService;
    @Autowired
    CaptionService captionService;
    @Autowired
    RestTemplate restTemplate;
    final String videoMinerUri = "http://localhost:8080/videominer/channels";



    @Operation(
            description = "Get a channel by specifying its id",
            tags = {"channel", "get"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = ChannelVimeo.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema())})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Channel getChannel(@PathVariable String id,
                              @RequestParam(required = false,defaultValue = "2") int maxVideos,
                              @RequestParam(required = false,defaultValue = "2") int maxComments) {
        ChannelVimeo channelVimeo = channelService.findOne(id, maxVideos, maxComments);
        Channel channel = ParserVideoMiner.parseChannel(channelVimeo);
        List<Video> videos = new LinkedList<>();
        List<VideoVimeo> videosVimeo = videoService.findVideosChannel(channelVimeo.getId(), maxComments, maxVideos);
        for(VideoVimeo videoVimeo:videosVimeo){
            Video video = ParserVideoMiner.parseVideo(videoVimeo);
            List<Comment> comentarios = commentService.findAllComments(videoVimeo.getId(), maxComments).stream().map(ParserVideoMiner::parseComment).toList();
            video.setComments(comentarios);
            List<Caption> captions = captionService.findCaptionsVideo(videoVimeo.getId()).stream().map(ParserVideoMiner::parseCaption).toList();
            video.setCaptions(captions);
            videos.add(video);
        }
        channel.setVideos(videos);
        return channel;
    }





    @Operation(
            description = "Create a channel",
            tags = {"channel", "post"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = { @Content(schema = @Schema(implementation = ChannelVimeo.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", content = { @Content(schema = @Schema())})
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{id}")
    public Channel sendChannel(@PathVariable String id,
                                    @RequestParam(required = false,defaultValue = "2") int maxVideos,
                                    @RequestParam(required = false,defaultValue = "2") int maxComments){
        Channel canal = ParserVideoMiner.parseChannel(channelService.findOne(id, maxComments, maxVideos));
        List<Video> videos = new LinkedList<>();
        List<VideoVimeo> videosVimeo = videoService.findVideosChannel(canal.getId(), maxComments, maxVideos);
        for(VideoVimeo videoVimeo:videosVimeo){
            Video video = ParserVideoMiner.parseVideo(videoVimeo);
            List<Comment> comentarios = commentService.findAllComments(videoVimeo.getId(), maxComments).stream().map(ParserVideoMiner::parseComment).toList();
            video.setComments(comentarios);
            List<Caption> captions = captionService.findCaptionsVideo(videoVimeo.getId()).stream().map(ParserVideoMiner::parseCaption).toList();
            video.setCaptions(captions);
            videos.add(video);
        }
        canal.setVideos(videos);
        HttpEntity<Channel> request = new HttpEntity<>(canal);
        ResponseEntity<Channel> response = restTemplate.exchange(videoMinerUri, HttpMethod.POST,request, Channel.class);
        return response.getBody();
    }
}