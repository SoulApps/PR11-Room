package com.example.mc_ra.pr11_room.ui.company;



import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mc_ra.pr11_room.BR;
import com.example.mc_ra.pr11_room.R;
import com.example.mc_ra.pr11_room.data.Repository;
import com.example.mc_ra.pr11_room.data.RepositoryImpl;
import com.example.mc_ra.pr11_room.databinding.FragmentCompanyListBinding;
import com.example.mc_ra.pr11_room.ui.main.MainActivityViewModel;

public class CompanyListFragment extends Fragment {

    private CompanyListAdapter mAdapter;
    private MainActivityViewModel mViewModel;
    Repository repository;

    public CompanyListFragment() {
    }

    public static CompanyListFragment newInstance() {
        return new CompanyListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        FragmentCompanyListBinding binding = FragmentCompanyListBinding.inflate(inflater, container, false);
        // Se retorna la vista raíz del layout.
        mAdapter = new CompanyListAdapter(BR.item);
        binding.companyList.setAdapter(mAdapter);
        binding.companyList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.companyList.setItemAnimator(new DefaultItemAnimator());
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}
