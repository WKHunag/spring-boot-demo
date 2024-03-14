package dev.demo.demo.model.entity;

import lombok.Data;

@Data
public class Movie {
    private Long id;
    private String imdbId;
    private String title;
    private String trailerLink;
    private String poster;
    private String releasedDate;
}
