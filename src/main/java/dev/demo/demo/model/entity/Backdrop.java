package dev.demo.demo.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Backdrop {
    private Long id;
    private String imageUrl;
    private String imdbId;
}
