package com.example.apemain.domains;

import java.util.List;
import java.util.Map;

public
record StaticTableInfomation
        (List<String> genresNames, List<String> typesNames, List<String> companyiesNames, List<String> artistsNames, List<String> recordLabelList,
         List<ItemIformation> recordNames, List<ItemIformation> instrumentNames) {
}
