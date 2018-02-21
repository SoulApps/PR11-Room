package com.example.mc_ra.pr11_room.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.example.mc_ra.pr11_room.Constants;
import com.example.mc_ra.pr11_room.data.local.AppDatabase;
import com.example.mc_ra.pr11_room.data.model.Company;
import com.example.mc_ra.pr11_room.utils.DatabaseUtils;

import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Mc_Ra on 14/02/2018.
 */

public class RepositoryImpl implements Repository{

    private static RepositoryImpl instance;
    private final AppDatabase db;


    private RepositoryImpl(final Context context) {
        db = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class, Constants.DATABASE_NAME).addCallback(
                new RoomDatabase.Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        DatabaseUtils.executeSqlFromAssetsFile(db, db.getVersion(), context.getAssets());
                    }
                }).build();
    }

    public static synchronized RepositoryImpl getInstance(Context context) {
        if (instance == null) {
            instance = new RepositoryImpl(context);
        }
        return instance;
    }

    @Override
    public LiveData<List<Company>> getCompanies() {
        return db.companyDao().getCompanies();
    }

    @Override
    public LiveData<Company> getCompany(long companyId) {
        return db.companyDao().getCompany(companyId);
    }

    @Override
    public long addCompany(Company company) {
        return db.companyDao().insertCompany(company);
    }

    @Override
    public int updateCompany(Company company) {
        return db.companyDao().updateCompany(company);
    }

    @Override
    public int deleteCompany(Company company) {
        return db.companyDao().deleteCompany(company);
    }
}
