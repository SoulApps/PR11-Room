package com.example.mc_ra.pr11_room.ui.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.example.mc_ra.pr11_room.data.Repository;
import com.example.mc_ra.pr11_room.data.RepositoryImpl;
import com.example.mc_ra.pr11_room.data.model.Company;

import java.util.List;



public class MainActivityViewModel extends AndroidViewModel{
    private final Repository repository = null;
    private LiveData<List<Company>> companies;

    public MainActivityViewModel(Application application, Repository repository) {
        super(application);
        repository = RepositoryImpl.getInstance(application.getApplicationContext());
        getCompanies();
    }

    public LiveData<List<Company>> getCompanies() {
        if (companies == null) {
            companies = repository.getCompanies();
            repository.addCompany(new Company(1,"Baldomero Empresa", "1234567", "Calle de la tortura",
                    "666888666","ramon.guardi@gj.com","https://static.seekingalpha.com/uploads/2017/10/11/48168758-15077295111917353_origin.png","Baldomero"));
        }
        return companies;
    }
}
