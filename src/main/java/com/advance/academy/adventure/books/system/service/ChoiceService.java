package com.advance.academy.adventure.books.system.service;

import com.advance.academy.adventure.books.system.model.adventure.Choice;
import com.advance.academy.adventure.books.system.model.adventure.Step;
import com.advance.academy.adventure.books.system.repository.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChoiceService {

    private final ChoiceRepository choiceRepository;

    @Autowired
    public ChoiceService(ChoiceRepository choiceRepository) {
        this.choiceRepository = choiceRepository;
    }

    public Choice createOrUpdate (Choice choice) {
        choice.setStepGivenIn(
                choiceRepository.getReference(
                        Step.class,
                        //or choice.getStepGivenIn().getClass(),
                        choice.getStepGivenIn().getId()
                )
        );
        choice.setResultsInStep(
                choiceRepository.getReference(
                        Step.class,
                        //or choice.getResultsInStep().getClass(),
                        choice.getResultsInStep().getId()
                )
        );
       Choice result = choiceRepository.save(choice);
       result.setStepGivenIn(null);
       result.setResultsInStep(null);
       return result;
    }
}
