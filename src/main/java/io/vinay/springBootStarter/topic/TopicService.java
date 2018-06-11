package io.vinay.springBootStarter.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("B01", "Book1", "This is book 1"),
            new Topic("B02", "Book2", "This is book 2"),
            new Topic("B03", "Book3", "This is book 3")
    ));

    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getById(String id) {
        try {
            return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        } catch (NoSuchElementException e) {
            // System.out.println("Oops..... No such Element Exist");
            return null;
        }
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }


    public boolean hasTopic(Topic topic) {
        if (getById(topic.getId()) == null)
            return false;
        return true;
    }

    public void updateTopic(String id, Topic topic) {

        for (int i = 0; i < topics.size(); ++i) {
            Topic t = topics.get(i);
            if (t.getId().equals(topic.getId())) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteById(String id) {
        /*
        for (int i = 0; i < topics.size(); ++i) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.remove(i);
                return;
            }
        }*/
        topics.removeIf(t -> t.getId().equals(id));
    }

}
