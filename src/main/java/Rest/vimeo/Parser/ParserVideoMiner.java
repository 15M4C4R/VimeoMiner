package Rest.vimeo.Parser;

import Rest.vimeo.model.Video.*;
import Rest.vimeo.model.Vimeo.caption.CaptionVimeo;
import Rest.vimeo.model.Vimeo.channel.ChannelVimeo;
import Rest.vimeo.model.Vimeo.comment.CommentVimeo;
import Rest.vimeo.model.Vimeo.user.UserVimeo;
import Rest.vimeo.model.Vimeo.video.VideoVimeo;

import java.util.ArrayList;
import java.util.List;


public class ParserVideoMiner {

    public static Channel parseChannel(ChannelVimeo channelVimeo){
        String id = channelVimeo.getId();
        String name = channelVimeo.getName();
        String description = channelVimeo.getDescription();
        String createdTime = channelVimeo.getCreatedTime();
        List<Video> videos = new ArrayList<>();
        for(VideoVimeo v : channelVimeo.getVideos()){
            parseVideo(v);
        }
        return new Channel(id, name, description, createdTime, videos);
    }

    public static Video parseVideo(VideoVimeo videoVimeo){
        String id = videoVimeo.getId();
        String name = videoVimeo.getName();
        String description = videoVimeo.getDescription();
        String releaseTime = videoVimeo.getReleaseTime();
        return new Video(id, name, description, releaseTime);
    }

    public static User parseUser(UserVimeo userVimeo){
        Long id = userVimeo.getId();
        String name = userVimeo.getName();
        String link = userVimeo.getLink();
        String pictureLink = userVimeo.getPicture_link();
        return new User(id, name, link, pictureLink);
    }

    public static Comment parseComment(CommentVimeo commentVimeo){
        String id = commentVimeo.getId();
        String text = commentVimeo.getText();
        String date = commentVimeo.getCreatedOn();
        User author = parseUser(commentVimeo.getUser());
        return new Comment(id, text, date, author);
    }

    public static Caption parseCaption(CaptionVimeo captionVimeo){
        String id = captionVimeo.getId();
        String name = captionVimeo.getName();
        String language = captionVimeo.getLanguage();
        return new Caption(id, name, language);
    }
}
