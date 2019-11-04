package com.advance.academy.adventure.books.system.model;

public class Hero {

    private Integer id;
    private String nickName;
    private Integer currentReputation;
    private Customer customer;
    private Adventure adventure;
    private Integer numberOfLives;

    public Integer getId() {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getCurrentReputation() {
        return currentReputation;
    }

    public void setCurrentReputation(Integer currentReputation) {
        this.currentReputation = currentReputation;
    }

    public Integer getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(Integer numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Adventure getAdventure() {
        return adventure;
    }

    public void setAdventure(Adventure adventure) {
        this.adventure = adventure;
    }
}
