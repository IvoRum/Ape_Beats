package com.example.apemain.domains;

import java.sql.Date;

public record CreateArtist(String artistName,
                           int recordLabelID,
                           Date date) {
}
