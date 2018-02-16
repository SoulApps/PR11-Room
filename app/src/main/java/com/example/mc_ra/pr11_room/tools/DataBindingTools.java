package com.example.mc_ra.pr11_room.tools;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

/**
 * Created by usuario on 16/02/2018.
 */

public class DataBindingTools {

    private DataBindingTools() {
    }

    // BindingAdapter to load image with Picasso
    @BindingAdapter(value = {"bind:imageUrl", "bind:placeholder", "bind:error"}, requireAll = false)
    public static void setImageUrl(ImageView imageView, String url, Drawable drawablePlaceholder,
                                   Drawable drawableError) {
        if (!TextUtils.isEmpty(url)) {
            RequestCreator peticion = Picasso.with(imageView.getContext()).load(url);
            if (drawablePlaceholder != null) {
                peticion.placeholder(drawablePlaceholder);
            }
            if (drawableError != null) {
                peticion.error(drawableError);
            }
            peticion.into(imageView);
        }
    }
}
