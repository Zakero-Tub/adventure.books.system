package com.advance.academy.adventure.books.system.model;

import javax.persistence.*;

@Entity
@Table(name = "choices")
public class Choice {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(name = "step_given_in_id")
    private Step stepGivenIn;

    @ManyToOne
    @JoinColumn(name = "results_in_step_id")
    private Step resultsInStep;


    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Step getStepGivenIn() { return stepGivenIn; }

    public void setStepGivenIn(Step stepGivenIn) { this.stepGivenIn = stepGivenIn; }

    public Step getResultsInStep() {
        return resultsInStep;
    }

    public void setResultsInStep(Step resultsInStep) {
        this.resultsInStep = resultsInStep;
    }

}
