package com.example.mc_ra.pr11_room.data.local;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.mc_ra.pr11_room.data.model.Company;

import java.util.List;

@Dao
public interface CompanyDao {

    @Insert
    long insertCompany(Company company);

    @Update
    int updateCompany(Company company);

    @Delete
    int deleteCompany(Company company);

    @Query("SELECT * FROM Company where id = :companyId")
    LiveData<Company> getCompany(long companyId);

    @Query("SELECT * FROM Company ORDER BY name")
    LiveData<List<Company>> getCompanies();
}
