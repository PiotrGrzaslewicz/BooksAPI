package com.example.booksapi.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Book  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long isbn;
    private String title;
    private String author;
    @OneToMany
    private List<Genre> genres;
    private Integer pages;
    private LocalDateTime published;
    @OneToOne
    private User borrower;
    private Boolean isBorrowed;

}
