package com.example.mc_ra.pr11_room.ui.company;


import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.DiffCallback;
import android.view.View;

import com.example.mc_ra.pr11_room.data.model.Company;
import com.example.mc_ra.pr11_room.utils.RecyclerBindingAdapter;

@SuppressWarnings("unused")
public class CompanyListAdapter extends RecyclerBindingAdapter<Company>{

    private final int modelBRId;

    public static final DiffCallback<Company> DIFF_CALLBACK = new DiffCallback<Company>() {
        @Override
        public boolean areItemsTheSame(@NonNull Company oldStudent, @NonNull Company newStudent) {
            return oldStudent.getId() == newStudent.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Company oldStudent,
                                          @NonNull Company newStudent) {
            return oldStudent.equals(newStudent);
        }
    };

    protected CompanyListAdapter(int modelBRId) {
        super(modelBRId, DIFF_CALLBACK);
        this.modelBRId = modelBRId;
    }

}
