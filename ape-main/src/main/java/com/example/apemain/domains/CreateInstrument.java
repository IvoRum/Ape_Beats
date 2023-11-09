package com.example.apemain.domains;

import java.sql.Date;

public record CreateInstrument(int price, int genreId, String description, Date manufacturingDate,String name, int companyId,Date date, int type) {
}
