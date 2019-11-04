package com.advance.academy.adventure.books.system.model;

public class Choice {

    private Integer id;
    private String description;
    private Step resultsInStep;
    private Step reputationChange;

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Step getResultsInStep() {
        return resultsInStep;
    }

    public void setResultsInStep(Step resultsInStep) {
        this.resultsInStep = resultsInStep;
    }

    public Step getReputationChange() {
        return reputationChange;
    }

    public void setReputationChange(Step reputationChange) {
        this.reputationChange = reputationChange;
    }
}
