package pl.edyta.b2wbackendchallange.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "games")
@Data
@AllArgsConstructor
public class Game {

    private String name;
    private String code;
    private Date date;
    private Dimension dimension;

}
