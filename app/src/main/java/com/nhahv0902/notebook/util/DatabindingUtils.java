package com.nhahv0902.notebook.util;

import android.databinding.BindingAdapter;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;

/**
 * Created by nhahv0902 on 7/5/2017.
 * <></>
 */

public class DatabindingUtils {
    @BindingAdapter("type_fonts")
    public static void fonts(AppCompatTextView view, String fonts) {
        view.setTypeface(Typeface.createFromAsset(view.getContext().getAssets(), fonts));
    }
}
