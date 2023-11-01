package com.example.apemain.domains;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@RequiredArgsConstructor
public class Record {
    private final String name;
    private final int price;
    private final boolean stock;
    private final String artistName;
    private final String recordLableName;
}
