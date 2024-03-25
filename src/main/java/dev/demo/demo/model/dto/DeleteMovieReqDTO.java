package dev.demo.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeleteMovieReqDTO {
    private String imdbId;
}
