package com.advance.academy.adventure.books.system.model.adventure;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@Entity
@Table(name = "choices")
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "step_given_in_id")
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Step stepGivenIn;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "results_in_step_id")
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Step resultsInStep;

    @Column(name = "reputation_change")
    private Integer reputationChange;


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

    public Integer getReputationChange() {
        return reputationChange;
    }

    public void setReputationChange(Integer reputationChange) {
        this.reputationChange = reputationChange;
    }

}
