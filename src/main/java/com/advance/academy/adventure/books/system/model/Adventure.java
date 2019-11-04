package com.advance.academy.adventure.books.system.model;

import org.hibernate.annotations.JoinColumnOrFormula;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "adventures")
public class Adventure {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "story")
    private String story;

    @OneToOne
    @JoinColumn(name = "first_step_id")
    private Step firstStep;

    @Column(name = "number_of_lives")
    private Integer numberOfLives;

    @Column(name = "starting_reputation")
    private Integer startingReputation;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "adventures_tags",
            joinColumns = { @JoinColumn(name = "adventure_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private Set<Tag> tags = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public Step getFirstStep() {
        return firstStep;
    }

    public void setFirstStep(Step firstStep) {
        this.firstStep = firstStep;
    }

    public Integer getNumberOfLives() {
        return numberOfLives;
    }

    public void setNumberOfLives(Integer numberOfLives) {
        this.numberOfLives = numberOfLives;
    }

    public Integer getStartingReputation() {
        return startingReputation;
    }

    public void setStartingReputation(Integer startingReputation) {
        this.startingReputation = startingReputation;
    }
}
