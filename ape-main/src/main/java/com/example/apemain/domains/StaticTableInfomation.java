package com.example.apemain.domains;

import java.util.List;

public
record StaticTableInfomation
        (List<String> genresNames,List<String> typesNames,List<String> companyiesNames,List<String> artistsNames, List<String> recordLabelList,
        List<String> recordNames,List<String> instrumentNames) {
}
