package pl.edyta.b2wbackendchallange.entity;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dimension {

    private Double weight;

    private Double height;

    private Double width;

    private Double length;
}
