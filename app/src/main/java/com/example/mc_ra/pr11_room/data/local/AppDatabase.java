package com.example.mc_ra.pr11_room.data.local;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.mc_ra.pr11_room.data.model.Company;

@Database(entities = {Company.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract CompanyDao companyDao();
}
