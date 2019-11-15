package com.advance.academy.adventure.books.system.repository;

import com.advance.academy.adventure.books.system.model.Hero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HeroRepository extends CrudRepository<Hero, Integer>, GetReference {

    @Query("SELECT h FROM Hero h WHERE customer.id = :customerId")
    Optional<List<Hero>> getHeroesBuCustomerId(@Param("customerId") Integer customerId);

}
