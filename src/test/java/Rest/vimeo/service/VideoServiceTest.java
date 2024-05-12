package Rest.vimeo.service;

import Rest.vimeo.model.Vimeo.video.VideoVimeo;
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
        List<VideoVimeo> videos= videoService.findVideosChannel("newyorker", 5, 5);
        assertFalse(videos==null, "Videos is empty");
        System.out.println(videos);
    }
}