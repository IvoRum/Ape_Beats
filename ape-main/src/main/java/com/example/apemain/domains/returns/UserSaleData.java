package com.example.apemain.domains.returns;

import com.example.apemain.domains.ItemData;

import java.sql.Date;
import java.util.List;

public record UserSaleData(Integer number, Integer amount, Date time_stamp, boolean fulfill, List<ItemData> utems ) {
}
