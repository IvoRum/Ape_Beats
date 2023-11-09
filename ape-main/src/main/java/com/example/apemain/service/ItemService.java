package com.example.apemain.service;

import com.example.apemain.domains.IdToNameInfomation;
import com.example.apemain.domains.StaticTableInfomation;
import com.example.apemain.repository.ApeRepository;
import com.example.apemain.repository.DropDownIfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemService {
    private final ApeRepository apeRepository;
    private final DropDownIfoRepository downIfoRepository;
    private final DataSource dataSource;

    public void updateItemName(final int id, final String name){
        try {
            apeRepository.updateItemName(id,name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public StaticTableInfomation getStaticTableInformation(){

        Connection connection = DataSourceUtils.getConnection(dataSource);
        List<IdToNameInfomation> genresNames=new ArrayList<>();
        List<IdToNameInfomation> typesNames=new ArrayList<>();
        List<IdToNameInfomation> companyiesNames=new ArrayList<>();
        List<IdToNameInfomation> artistsNames=new ArrayList<>();
        List<IdToNameInfomation> recordLabelList=new ArrayList<>();
        List<IdToNameInfomation> recordNames=new ArrayList<>();
        List<IdToNameInfomation> instrumentNames=new ArrayList<>();
        try{
            artistsNames=downIfoRepository.getArtistNames(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            typesNames=downIfoRepository.getAllIstrumentTypes(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            genresNames=downIfoRepository.getRecordGenres(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            companyiesNames=downIfoRepository.getCompanyNames(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            instrumentNames=downIfoRepository.getInstrumentNames(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            recordNames=downIfoRepository.getRecordNames(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try{
            recordLabelList=downIfoRepository.getRecordLabelNames(connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new StaticTableInfomation(genresNames,typesNames,companyiesNames,artistsNames,recordLabelList,recordNames,instrumentNames);
    }
/*
    public
    List<String> getGenresNames() {
        try{
        return downIfoRepository.getRecordGenres();
    } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public
    List<String> getTypesNames() {
        try{
            return downIfoRepository.getAllIstrumentTypes();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public
    List<String> getCompaniesNames() {
        try{
            return downIfoRepository.getCompanyNames();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public
    List<String> getArtistNames() {
        try{
            return downIfoRepository.getArtistNames();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public
    List<String> getRecordLabelNames() {
        try{
            return downIfoRepository.getRecordLabelNames();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public
    List<String> getRecordNames() {
        try{
            return downIfoRepository.getRecordNames();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public
    List<String> getInstrumentNames() {
        try{
            return downIfoRepository.getInstrumentNames();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    */
}
