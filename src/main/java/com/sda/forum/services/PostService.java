package com.sda.forum.services;


import com.sda.forum.entities.Post;
import com.sda.forum.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    /**
     * Cand salvam un Post trebuie sa incrementam si numarul de posturi al User-ului care a creat POSTul.
     *
     */
    public Post createPost(Post post){
        if(post.getTopic().getMinAge()<=post.getUser().getAge()) {
            Post savedPost = postRepository.save(post);
            savedPost.getUser().incrementPostNumber();
            userService.updateUser(savedPost.getUser());
            return savedPost;
        } else {
            throw new RuntimeException();
        }
    }
}
