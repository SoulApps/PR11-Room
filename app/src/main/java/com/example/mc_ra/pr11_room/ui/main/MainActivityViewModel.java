package com.example.mc_ra.pr11_room.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mc_ra.pr11_room.data.Repository;
import com.example.mc_ra.pr11_room.data.RepositoryImpl;
import com.example.mc_ra.pr11_room.data.model.Company;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class MainActivityViewModel extends AndroidViewModel{
    private  Repository repository;
    private LiveData<List<Company>> companies;

    public MainActivityViewModel(Application application) {
        super(application);
        //todo fix this
        repository = RepositoryImpl.getInstance(application.getApplicationContext());
    }

    public LiveData<List<Company>> getCompanies() {
        if (companies == null) {
            companies = repository.getCompanies();
        }
        return companies;
    }
}
