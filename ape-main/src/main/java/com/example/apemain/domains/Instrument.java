package com.example.apemain.domains;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@Data
public class Instrument {
    private final String type;
    private final String name;
    private final String company;
    private final boolean inStock;
    private final int price;
    private final Date date;
    private final String genre;
    private final String discrimination;
}
