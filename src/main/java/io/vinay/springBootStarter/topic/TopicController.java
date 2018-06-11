package io.vinay.springBootStarter.topic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @RequestMapping("topics")
    public List<Topic> getAllTopics() {
        return Arrays.asList(
                new Topic("B01", "Book1", "This is book 1"),
                new Topic("B02", "Book2", "This is book 2"),
                new Topic("B03", "Book3", "This is book 3")
        );
    }

}
