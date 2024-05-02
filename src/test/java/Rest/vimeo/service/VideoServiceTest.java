package Rest.vimeo.service;

import Rest.vimeo.model.video.Video;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VideoServiceTest {

    @Autowired
    VideoService videoService;

    @Test
    void findVideosChannel() {
        List<Video> videos= videoService.findVideosChannel("newyorker");
        assertFalse(videos==null, "Videos is empty");
        System.out.println(videos);
    }
}