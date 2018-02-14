package com.example.mc_ra.pr11_room.ui.main;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mc_ra.pr11_room.data.Repository;
import com.example.mc_ra.pr11_room.data.model.Company;

import java.util.List;

/**
 * Created by Mc_Ra on 14/02/2018.
 */

public class MainActivityViewModel extends ViewModel{
    private final Repository repository;
    private LiveData<List<Company>> companies;

    public MainActivityViewModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<Company>> getCompanies() {
        if (companies == null) {
            companies = repository.getCompanies();
        }
        return companies;
    }
}
