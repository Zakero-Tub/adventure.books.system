package com.advance.academy.adventure.books.system.service;

import com.advance.academy.adventure.books.system.model.Hero;
import com.advance.academy.adventure.books.system.repository.HeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeroService {

        private final HeroRepository heroRepository;

    @Autowired
    public HeroService(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    public void createOrUpdate (Hero hero){
        heroRepository.save(hero);
    }

    public List<Hero> getHeroesByCustomerId(Integer customerId){
        List<Hero> heroList = new ArrayList<>();
        Optional <List<Hero>> result = heroRepository.getHeroesBuCustomerId(customerId);
        if(result.isPresent()) {
            heroList.addAll(result.get());
        }
        return heroList;
    }

    public Hero getHeroById(Integer heroId){
        Hero hero = null;
        Optional <Hero> result = heroRepository.findById(heroId);
        if(result.isPresent()) {
            hero = result.get();
        }
        return hero;
    }

}
