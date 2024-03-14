package dev.demo.demo.model.entity;

import lombok.Data;

@Data
public class Review {
    private Long id;
    private String content;
    private String imdb;
    private String createdDate;
    private String updatedDate;
}
