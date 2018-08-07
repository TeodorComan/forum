package com.sda.forum.repositories;

import com.sda.forum.entities.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic,Integer> {


}
