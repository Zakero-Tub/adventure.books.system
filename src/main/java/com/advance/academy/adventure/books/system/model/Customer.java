package com.advance.academy.adventure.books.system.model;

import com.advance.academy.adventure.books.system.model.enums.UserType;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private Integer id;
    private UserType type;
    private String email;
    private String userName;
    private List<Hero> heroList = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Hero> getHeroList() {
        return heroList;
    }

    public void setHeroList(List<Hero> heroList) {
        this.heroList = heroList;
    }
}
