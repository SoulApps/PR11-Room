package com.example.mc_ra.pr11_room.ui.company;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mc_ra.pr11_room.data.Repository;
import com.example.mc_ra.pr11_room.data.model.Company;

/**
 * Created by Mc_Ra on 14/02/2018.
 */

public class CompanyActivityViewModel extends ViewModel {
    private final Repository repository;
    private LiveData<Company> company;

    public CompanyActivityViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<Company> getCompany(long companyId) {
        if (company == null) {
            company = repository.getCompany(companyId);
        }
        return company;
    }
}
