package com.sda.forum.model;

import com.sda.forum.entities.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Date;

public class UserModel {

    @Size(min=2, max=30)
    public String userName;
    @Positive
    public  int age;

    public User toUser(){
        User user = new User();
        user.setAge(this.age);
        user.setUsername(this.userName);

        return user;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
