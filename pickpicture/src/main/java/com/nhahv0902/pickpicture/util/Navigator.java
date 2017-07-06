package com.nhahv0902.pickpicture.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by nhahv0902 on 7/6/17.
 * <></>
 */

public class Navigator {
    private final String NOTEBOOK_TAG = "NOTEBOOK_TAG";
    private Activity mActivity;

    public Navigator(Activity activity) {
        mActivity = activity;
    }

    public Context getContext() {
        if (mActivity != null) {
            return mActivity.getApplicationContext();
        }
        return null;
    }

    public void startActivity(Intent intent) {
        mActivity.startActivity(intent);
    }

    public void log(String message) {
        if (mActivity.getApplicationContext() != null) {
            Log.d(NOTEBOOK_TAG, message);
        }
    }

    public void toast(@NonNull String message) {
        if (mActivity != null) {
            Toast.makeText(mActivity.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    public void toast(int message) {
        if (mActivity != null) {
            Toast.makeText(mActivity.getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
