package dev.demo.demo.model.dto;

import dev.demo.demo.model.entity.Movie;
import lombok.Data;

import java.util.List;

@Data
public class NewMovieReqDTO {
    Movie movie;
    List<String> backdrops;
    List<String> genres;
}
