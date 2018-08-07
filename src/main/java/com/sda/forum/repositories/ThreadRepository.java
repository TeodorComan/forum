package com.sda.forum.repositories;

import com.sda.forum.entities.Thread;
import org.springframework.data.repository.CrudRepository;

public interface ThreadRepository extends CrudRepository<Thread,Integer> {
}
