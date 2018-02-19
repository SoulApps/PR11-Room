package com.example.mc_ra.pr11_room.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mc_ra.pr11_room.R;
import com.example.mc_ra.pr11_room.ui.company.CompanyDetailActivity;
import com.example.mc_ra.pr11_room.ui.company.CompanyListFragment;
import com.example.mc_ra.pr11_room.utils.FragmentUtils;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_COMPANY_FRAGMENT = "TAG_COMPANY_FRAGMENT";
    private static final int EXTRA_RC = 2;
    private MainActivityViewModel mViewModel;
    // todo solve load error

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(view -> createNewCompany());
    }

    private void createNewCompany() {
        CompanyDetailActivity.startForCreateCompany(this,EXTRA_RC);
    }

    private void loadFragment() {
        FragmentUtils.replaceFragment(getSupportFragmentManager(),R.id.activity_main_container,
                CompanyListFragment.newInstance(),TAG_COMPANY_FRAGMENT);
    }

}
