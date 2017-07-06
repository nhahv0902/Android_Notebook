package com.nhahv0902.notebook.screen;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import com.facebook.FacebookSdk;
import com.nhahv0902.notebook.R;

/**
 * Created by nhahv0902 on 7/4/17.
 * base activity common for activity
 */

@SuppressLint("Registered")
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onChildTitleChanged(Activity childActivity, CharSequence title) {
        super.onChildTitleChanged(childActivity, title);
        FacebookSdk.setApplicationId(getString(R.string.facebook_app_id));
    }
}
