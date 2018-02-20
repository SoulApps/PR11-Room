package com.example.mc_ra.pr11_room.ui.company;

import android.app.Activity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.example.mc_ra.pr11_room.R;
import com.example.mc_ra.pr11_room.data.Repository;
import com.example.mc_ra.pr11_room.data.RepositoryImpl;
import com.example.mc_ra.pr11_room.data.model.Company;
import com.example.mc_ra.pr11_room.databinding.ActivityCompanyDetailBinding;
import com.example.mc_ra.pr11_room.ui.main.MainActivityViewModel;
import com.example.mc_ra.pr11_room.utils.ValidationUtils;

import io.reactivex.Single;

public class CompanyDetailActivity extends AppCompatActivity {
    private static final int EXTRA_RC = 1;
    private static final String COMPANY_EXTRA = "COMPANY_EXTRA";
    private boolean hasData;
    private Company company;
    private Intent intent;
    private Repository mRepository;
    private MainActivityViewModel mViewModel;
    //todo traducir
    // todo comentar codigo
    // todo limpiar codigo
    // todo insertar
    // todo eliminar
    // todo editar
    // todo emptyView
    ActivityCompanyDetailBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_company_detail);
        intent = getIntent();
        mBinding.companyDetailFab.setOnClickListener(view -> manageCompany(company));
        checkData(intent);
        obtainDBData();
        mBinding.setItem(company);
    }

    private void obtainDBData() {
        mViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mRepository = RepositoryImpl.getInstance(this);
    }

    private void checkData(Intent data) {
        if (data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                if (data.hasExtra(COMPANY_EXTRA)) {
                    company = extras.getParcelable(COMPANY_EXTRA);
                    hasData = true;
                }
            }
        } else {
            hasData = false;
        }
    }

    private void manageCompany(Company comp) {
        if (comp == null && !hasData) {
            // if company is null, we will create a new one
            if(ValidationUtils.checkEmpty(mBinding)){
                // If texts are not empty and validated
                comp = new Company(mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtCpmpanyName.getText().toString(),
                        mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtCIF.getText().toString(),
                        mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtAddress.getText().toString(),
                        mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtPhone.getText().toString(),
                        mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtEmail.getText().toString(),
                        mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtURL.getText().toString(),
                        mBinding.contentCompanyDetailInclude.contentCompanyDetailTxtContact.getText().toString());
                company = comp;
                insertCompany(comp);
                this.finish();
            }
        } else {
            // else we will edit the user
        }

    }

    private void insertCompany(Company comp) {
        Single<LiveData<Long>> result = Single.create(emitter -> emitter.onSuccess(mRepository.addCompany(comp)));
    }




    // Método estático para iniciar la actividad (esperando un resultado).
    public static void startForResult(Activity activity, int requestCode, Company company) {
        Intent intent;
        intent = new Intent(activity, CompanyDetailActivity.class);
        intent.putExtra(COMPANY_EXTRA, company);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void startForCreateCompany(Activity activity, int requestCode) {
        Intent intent;
        intent = new Intent(activity, CompanyDetailActivity.class);
        activity.startActivityForResult(intent, requestCode);
    }
}
