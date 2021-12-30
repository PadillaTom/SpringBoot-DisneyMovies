package com.dinsney.disneyworld.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "characters")
@Getter
@Setter
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    private String name;

    private int age;

    private double weight;

    private String history;

    // Has Many Movies:
    @ManyToMany(
            mappedBy = "characters",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<MovieEntity> movies = new ArrayList<>();

}
