package com.advance.academy.adventure.books.system.repository;

import com.advance.academy.adventure.books.system.model.adventure.Adventure;
import org.springframework.data.repository.CrudRepository;

public interface AdventureRepository extends CrudRepository<Adventure, Integer> {


}
