package com.example.apemain.domains.returns;

import java.sql.Date;

public record UserSaleData(Integer number, Integer amount, Date time_stamp,boolean fulfill) {
}
