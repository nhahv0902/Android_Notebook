package com.nhahv0902.notebook.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by nhahv0902 on 7/6/17.
 * <></>
 */

public class Navigator {
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
}
