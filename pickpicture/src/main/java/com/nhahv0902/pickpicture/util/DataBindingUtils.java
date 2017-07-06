package com.nhahv0902.pickpicture.util;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nhahv0902.pickpicture.R;

/**
 * Created by nhahv0902 on 7/8/2017.
 * <></>
 */

public class DataBindingUtils {
    @BindingAdapter("src_image")
    public static void srcImage(ImageView view, String path) {
        Glide.with(view.getContext()).load(path).placeholder(R.drawable.icon_placeholder).thumbnail(1f).into(view);
    }
}
