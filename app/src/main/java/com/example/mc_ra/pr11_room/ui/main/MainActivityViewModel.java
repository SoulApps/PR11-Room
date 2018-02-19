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
            new Thread(new Runnable() {
                @Override
                public void run() {
                    repository.addCompany(new Company("Baldomero Empresa", "1234567", "Calle de la tortura",
                            "666888666","ramon.guardi@gj.com","https://static.seekingalpha.com/uploads/2017/10/11/48168758-15077295111917353_origin.png","Baldomero"));
                     repository.addCompany(new Company("Baldomero Empresa", "1234567", "Calle de la tortura",
                            "666888666","ramon.guardi@gj.com","http://1.bp.blogspot.com/-5bPNsF5plzw/VnJWs-7RbrI/AAAAAAAARmA/DaZmn8YUjAk/s1600-r/logo_research_at_google_color_1x_web_512dp.png","Baldomero"));

                }
            }).start();
        }
        return companies;
    }
}
