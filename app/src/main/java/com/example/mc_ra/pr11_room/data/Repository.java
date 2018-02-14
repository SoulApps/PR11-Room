package com.example.mc_ra.pr11_room.data;

import android.arch.lifecycle.LiveData;

import com.example.mc_ra.pr11_room.data.model.Company;

import java.util.List;

/**
 * Created by Mc_Ra on 14/02/2018.
 */

public interface Repository {
    LiveData<List<Company>> getCompanies();
    LiveData<Company> getCompany(long companyId);
    long addCompany(Company company);
    int updateCompany(Company company);
    int deleteCompany(Company company);
}
