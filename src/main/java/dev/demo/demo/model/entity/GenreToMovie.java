package dev.demo.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GenreToMovie {
    private Long id;
    private String imdbId;
    private String name;
    private String definition;
    private String createdDate;
    private String updatedDate;
}
