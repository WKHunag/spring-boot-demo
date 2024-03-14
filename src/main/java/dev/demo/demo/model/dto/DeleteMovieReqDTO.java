package dev.demo.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class DeleteMovieReqDTO {
    private String imdbId;
}
