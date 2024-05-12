package Rest.vimeo.service;

import Rest.vimeo.model.Vimeo.caption.CaptionVimeo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CaptionServiceTest {

    @Autowired
    CaptionService captionService;

    @Test
    void findCaptions() {
        List<CaptionVimeo> captions = captionService.findCaptionsVideo("781632604");
        assertFalse(captions==null, "Captions is empty");
        System.out.println(captions);
    }
}