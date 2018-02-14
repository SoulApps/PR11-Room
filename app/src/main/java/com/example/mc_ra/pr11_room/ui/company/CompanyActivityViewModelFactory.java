package com.example.mc_ra.pr11_room.ui.company;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.mc_ra.pr11_room.data.Repository;


public class CompanyActivityViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final Repository repository;

    public CompanyActivityViewModelFactory(Repository repository) {
        this.repository = repository;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new CompanyActivityViewModel(repository);
    }
}
