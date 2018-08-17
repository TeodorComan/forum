package com.sda.forum.entities;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class User implements UserDetails {


    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Post> myPosts;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Topic> myTopics;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "creator")
    private List<Thread> myThreads;

    @Column(nullable = false)
    private String password;

    @Column(name="postnumber")
    private int postNumber;

    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Post> getMyPosts() {
        return myPosts;
    }

    public void setMyPosts(List<Post> myPosts) {
        this.myPosts = myPosts;
    }

    public List<Topic> getMyTopics() {
        return myTopics;
    }

    public void setMyTopics(List<Topic> myTopics) {
        this.myTopics = myTopics;
    }

    public List<Thread> getMyThreads() {
        return myThreads;
    }

    public void setMyThreads(List<Thread> myThreads) {
        this.myThreads = myThreads;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List authorities = new ArrayList();

        authorities.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "USER";
            }
        });

        return authorities;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void incrementPostNumber() {
        this.postNumber++;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", postNumber=" + postNumber +
                ", age=" + age +
                '}';
    }
}
