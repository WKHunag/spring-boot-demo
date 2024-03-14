package dev.demo.demo.model.dto;

import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
public class MovieDTO {
    private String imdbId;
    private String title;
    private String trailerLink;
    private String poster;
    private String releasedDate;
    private List<String> backdrops = new ArrayList<>();
    private List<String> reviews = new ArrayList<>();
}
