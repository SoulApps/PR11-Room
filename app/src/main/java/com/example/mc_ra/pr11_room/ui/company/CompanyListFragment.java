package com.example.mc_ra.pr11_room.ui.company;



import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mc_ra.pr11_room.BR;
import com.example.mc_ra.pr11_room.R;
import com.example.mc_ra.pr11_room.data.Repository;
import com.example.mc_ra.pr11_room.data.model.Company;
import com.example.mc_ra.pr11_room.databinding.FragmentCompanyListBinding;
import com.example.mc_ra.pr11_room.ui.main.MainActivityViewModel;
import com.example.mc_ra.pr11_room.utils.RecyclerBindingAdapter;

import java.util.List;


public class CompanyListFragment extends Fragment {

    private CompanyListAdapter mAdapter;
    private MainActivityViewModel mViewModel;
    Repository repository;
    private final int EXTRA_RC = 1;
    private final String COMPANY_EXTRA = "COMPANY_EXTRA";
    private View emptyView;
    //FragmentCompanyListBinding mBinding;

    public CompanyListFragment() {
    }

    public static CompanyListFragment newInstance() {
        return new CompanyListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* mBinding = DataBindingUtil.setContentView(getActivity(), R.layout.fragment_company_list);
        mBinding.setPresenter(this);*/
        mViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModel.class);


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        FragmentCompanyListBinding binding = FragmentCompanyListBinding.inflate(inflater, container, false);
        binding.setPresenter(this);
        // Se retorna la vista raíz del layout.
        if (container != null) {
            emptyView = container.findViewById(R.id.company_list_empty_view_ConstraintLayout);
        }
        mAdapter = new CompanyListAdapter(BR.item);
        binding.companyList.setAdapter(mAdapter);
        binding.companyList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        binding.companyList.setItemAnimator(new DefaultItemAnimator());
        binding.companyList.addItemDecoration(new DividerItemDecoration(inflater.getContext(),DividerItemDecoration.VERTICAL));
        mViewModel.getCompanies().observe(this, this::update);
        mAdapter.setEmptyView(emptyView);
        return binding.getRoot();
    }

    private void update(List<Company> companies) {
        mAdapter.setList(companies);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    public  void sendToDetailActivity(Company item) {
        Intent intent = new Intent();
        intent.putExtra(COMPANY_EXTRA, item);
        CompanyDetailActivity.startForResult(getActivity(),EXTRA_RC, item);
    }

    public void onItemClick(View view, Object item, int position){
        sendToDetailActivity((Company) item);
    }

    public void onItemLongClick(View view, Object item, int position){
        sendToDetailActivity((Company) item);
    }
}
