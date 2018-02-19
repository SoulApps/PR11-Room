package com.example.mc_ra.pr11_room.ui.company;


import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;
import android.view.View;

import com.example.mc_ra.pr11_room.data.model.Company;
import com.example.mc_ra.pr11_room.utils.RecyclerBindingAdapter;

@SuppressWarnings("unused")
public class CompanyListAdapter extends RecyclerBindingAdapter<Company> {

    private final int modelBRId;
    // todo copy paste
    public static final DiffCallback<Company> DIFF_CALLBACK = new DiffCallback<Company>() {
        @Override
        public boolean areItemsTheSame(@NonNull Company oldCompany, @NonNull Company newCompany) {
            return oldCompany.getId() == newCompany.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Company oldCompany,
                                          @NonNull Company newCompany) {
            return oldCompany.equals(newCompany);
        }
    };

    protected CompanyListAdapter(int modelBRId) {
        super(modelBRId, DIFF_CALLBACK);
        this.modelBRId = modelBRId;
    }


}
