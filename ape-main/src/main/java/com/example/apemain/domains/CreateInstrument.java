package com.example.apemain.domains;

import java.sql.Date;

public record CreateInstrument(int price, int genraId, String description, Date manufacturingDate,String name, int genreId, int companyId,Date date, int type) {
}
