package io.vinay.springBootStarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic getById(@PathVariable String id) {
        return topicService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST , value = "/topics")
    public void addTopic(@RequestBody Topic topic) {

        if (!topicService.hasTopic(topic))
            topicService.addTopic(topic);
        else
            System.out.println("This item already exist in the current list!!");
    }

    @RequestMapping(method = RequestMethod.PUT , value = "/topics/{id}")
    public void updatetopic(@PathVariable String id, @RequestBody Topic topic) {
        topicService.updateTopic(id,topic);
    }

    @RequestMapping(method = RequestMethod.DELETE , value = "/topics/{id}")
    public void delete(@PathVariable String id){
        topicService.deleteById(id);
    }
}
