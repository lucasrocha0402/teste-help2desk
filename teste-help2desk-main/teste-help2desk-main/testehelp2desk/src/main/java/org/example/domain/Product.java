package org.example.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {


    private Long id;
    private String title;
    private Double Price;
    private String description;
    private String category;
    private String image;

    private Rating rating;
}
