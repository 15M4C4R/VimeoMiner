package Rest.vimeo.service;

import Rest.vimeo.model.Channel;
import Rest.vimeo.model.Video;
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
    void findAll() {
        List<Video> videos= videoService.findAll("newyorker");
        assertFalse(videos==null, "Videos is empty");
        System.out.println(videos);
    }
}