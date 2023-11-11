package com.example.apemain.domains.returns;

import com.example.apemain.domains.returns.IdToNameInfomation;

import java.util.List;

public
record StaticTableInfomation
        (List<IdToNameInfomation> genresNames, List<IdToNameInfomation> typesNames,
         List<IdToNameInfomation> companyiesNames, List<IdToNameInfomation> artistsNames,
         List<IdToNameInfomation> recordLabelList, List<IdToNameInfomation> recordNames,
         List<IdToNameInfomation> instrumentNames) {
}
