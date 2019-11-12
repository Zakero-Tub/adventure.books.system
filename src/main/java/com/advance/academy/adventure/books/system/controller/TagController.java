package com.advance.academy.adventure.books.system.controller;


import com.advance.academy.adventure.books.system.model.Tag;
import com.advance.academy.adventure.books.system.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tag")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public void creadeOrUpdateTag(@RequestBody Tag tag){
        tagService.createOrUpdate(tag);
    }

    @GetMapping
    public List<Tag> getAll(){
        return tagService.getAllTags();
    }

    @GetMapping("/adventures/{adventureId}")
    public List<Tag> getAllByAdventureId(@PathVariable ("adventureId") Integer adventureId){
        return tagService.getAllTagsByAdventureId(adventureId);
    }

    @GetMapping("/{tagId}")
    public Tag getTag(@PathVariable ("tagId") Integer tagId){
        return tagService.getTagById(tagId);
    }
}
