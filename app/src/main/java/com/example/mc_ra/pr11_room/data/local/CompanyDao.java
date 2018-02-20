package com.example.mc_ra.pr11_room.data.local;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.mc_ra.pr11_room.data.model.Company;

import java.util.List;

import io.reactivex.Observable;

@Dao
public interface CompanyDao {

    @Insert
    LiveData<Long> insertCompany(Company company);

    @Update
    LiveData<Integer> updateCompany(Company company);

    @Delete
    LiveData<Integer> deleteCompany(Company company);

    @Query("SELECT * FROM Company where id = :companyId")
    LiveData<Company> getCompany(long companyId);

    @Query("SELECT * FROM Company ORDER BY name")
    LiveData<List<Company>> getCompanies();
}
