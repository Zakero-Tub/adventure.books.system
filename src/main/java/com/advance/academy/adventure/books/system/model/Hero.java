package com.advance.academy.adventure.books.system.model;

import javax.persistence.*;

@Entity
@Table(name = "heroes")
public class Hero {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nick_name")
    private String nickName;

    @Column(name = "current_reputation")
    private Integer currentReputation;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "adventure_id")
    private Adventure adventure;

    @Column(name = "number_of_lives")
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
