package com.example.apemain.domains;

import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Date;

public record CreateRecord(int price,
                            String description,
                            Date manufacturingDate,
                            String name,
                            int genreId,
                            int companyId,
                            Date date,
                            int artistId,
                            int recordLabelId) {
}
