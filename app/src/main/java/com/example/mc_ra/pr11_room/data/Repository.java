package com.example.mc_ra.pr11_room.data;

import android.arch.lifecycle.LiveData;

import com.example.mc_ra.pr11_room.data.model.Company;

import java.util.List;

public interface Repository {
    LiveData<List<Company>> getCompanies();


    long addCompany(Company company);

    int updateCompany(Company company);

    int deleteCompany(Company company);
}
