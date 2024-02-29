package dev.demo.demo.model;

import lombok.Data;
import java.sql.Date;

@Data
public class GenreToMovie {
    private long id;
    private String imdbId;
    private String name;
    private String definition;
    private Date create_date;
    private Date update_date;
}
