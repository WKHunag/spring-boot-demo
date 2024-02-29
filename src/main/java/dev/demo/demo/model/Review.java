package dev.demo.demo.model;

import lombok.Data;

import java.sql.Date;

@Data
public class Review {
    private long id;
    private String content;
    private Date createdDate;
    private Date updatedDate;
}
