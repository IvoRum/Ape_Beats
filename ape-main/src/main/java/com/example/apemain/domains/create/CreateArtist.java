package com.example.apemain.domains.create;

import java.sql.Date;

public record CreateArtist(String artistName,
                           int recordLabelID,
                           Date date) {
}
