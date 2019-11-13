package com.advance.academy.adventure.books.system.repository;

import com.advance.academy.adventure.books.system.model.adventure.Choice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChoiceRepository extends CrudRepository <Choice, Integer> , GetReference {


}

