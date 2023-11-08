package com.example.apemain.service;

import com.example.apemain.domains.StaticTableInfomation;
import com.example.apemain.repository.ApeRepository;
import com.example.apemain.repository.DropDownIfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private final ApeRepository apeRepository;
    private final DropDownIfoRepository downIfoRepository;

    public void updateItemName(final int id, final String name){
        try {
            apeRepository.updateItemName(id,name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public StaticTableInfomation getStaticTableInformation(){
        List<String> genresNames=new ArrayList<>();
        List<String> typesNames=new ArrayList<>();
        List<String> companyiesNames=new ArrayList<>();
        List<String> artistsNames=new ArrayList<>();
        List<String> recordLabelList=new ArrayList<>();
        List<String> recordNames=new ArrayList<>();
        List<String> instrumentNames=new ArrayList<>();
        try {
            typesNames=downIfoRepository.getAllIstrumentTypes();
            genresNames=downIfoRepository.getRecordGenres();
            companyiesNames=downIfoRepository.getCompanyNames();
            artistsNames=downIfoRepository.getArtistNames();
            recordLabelList=downIfoRepository.getRecordLabelNames();
            recordNames=downIfoRepository.getRecordNames();
            instrumentNames=downIfoRepository.getInstrumentNames();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new StaticTableInfomation(genresNames,typesNames,companyiesNames,artistsNames,recordLabelList,recordNames,instrumentNames);
    }
}
