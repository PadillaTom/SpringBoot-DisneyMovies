package com.dinsney.disneyworld.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genre")
@Getter
@Setter
public class GenreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    // Has Many Movies:
    @ManyToMany(
            mappedBy = "genres",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<MovieEntity> movies = new ArrayList<>();
}
