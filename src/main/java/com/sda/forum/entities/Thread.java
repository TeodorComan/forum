package com.sda.forum.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Thread {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = User.class)
    private User creator;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Topic.class, mappedBy = "thread")
    private List<Topic> topics;

    private Boolean status;


    public Thread(String title, User creator) {
        this.title = title;
        this.creator = creator;
    }

    public Thread() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
