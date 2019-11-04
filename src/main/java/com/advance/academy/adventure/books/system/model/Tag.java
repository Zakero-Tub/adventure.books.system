package com.advance.academy.adventure.books.system.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "value", unique = true)
    private String value;

    @ManyToMany(mappedBy = "tags")
    private Set<Adventure> adventures = new HashSet<>();


}
