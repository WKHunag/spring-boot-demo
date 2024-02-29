package dev.demo.demo.model;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class Movie {
    private long id;
    private String imdbId;
    private String title;
    private String trailerLink;
    private List<String> genres = new ArrayList<>();
    private String poster;
    private Date releaseDate;
    private List<String> backdrops = new ArrayList<>();
    private List<String> reviews = new ArrayList<>();
}
