package com.sda.forum.services;


import com.sda.forum.entities.Topic;
import com.sda.forum.repositories.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    public Topic createTopic(Topic topic){
        return topicRepository.save(topic);
    }

    public Topic updateTopic(Topic topic){
        return topicRepository.save(topic);
    }

    public Topic readTopic(int id) {
        return topicRepository.findById(id).get();
    }

    public void deleteTopic(Topic topic){
        topicRepository.delete(topic);
    }
}
