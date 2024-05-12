package Rest.vimeo.service;

import Rest.vimeo.model.Vimeo.channel.ChannelVimeo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChannelServiceTest {

    @Autowired
    ChannelService channelService;

    @Test
    void findOne() {
        ChannelVimeo channel = channelService.findOne("newyorker", 5 ,5);
        assertFalse(channel==null, "Channel is empty");
        System.out.println(channel);
    }



    @Test
    void setOne() {
    }
}