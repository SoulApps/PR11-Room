package com.example.mc_ra.pr11_room.utils;


import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.support.v7.recyclerview.extensions.ListAdapter;

@SuppressWarnings("unused")
public class RecyclerBindingAdapter<T extends RecyclerBindingAdapter.ViewModel>
        extends ListAdapter<T, RecyclerBindingAdapter.ViewHolder>{


    public interface  ViewModel {
        @SuppressWarnings("SameReturnValue")
        int getLayoutId();
    }

    static public class ViewHolder extends RecyclerView.ViewHolder {


        private final ViewDataBinding binding;
        private final int modelBRId;

        public ViewHolder(ViewDataBinding binding, int modelBRId) {
            super(binding.getRoot()); // Root corresponds to itemview.
            this.binding = binding;
            this.modelBRId = modelBRId;
        }

        public ViewDataBinding getBinding() {
            return binding;
        }

        public void bind(Object item) {
            binding.setVariable(modelBRId, item);
            binding.executePendingBindings();
        }

    }
}
