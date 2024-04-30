package Rest.vimeo.service;

import Rest.vimeo.model.Channel;
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
        Channel channel = channelService.findOne("newyorker");
        assertFalse(channel==null, "Channel is empty");
        System.out.println(channel);
    }



    @Test
    void setOne() {
    }
}