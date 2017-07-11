package com.nhahv0902.pickpicture.util;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import com.nhahv0902.pickpicture.R;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nhahv0902 on 7/10/17.
 * <></>
 */

public class Permissions {

    private final Map<String, Integer> mHashPermission = new HashMap<>();

    private AppCompatActivity mActivity;

    public Permissions(@NonNull AppCompatActivity activity) {
        mActivity = activity;
    }

    public boolean requestPermission(@NonNull String permission, int codeRequest, int message) {
        if (isHashPermission(permission)) {
            return true;
        }
        if (!mHashPermission.containsKey(permission)) {
            mHashPermission.put(permission, codeRequest);
        }
        if (isShowRequest(permission)) {
            showExplainRequest(permission, codeRequest, message);
        } else {
            request(permission, codeRequest);
        }
        return false;
    }

    private void showExplainRequest(@NonNull final String permission, final int codeRequest,
            int message) {
        if (mActivity == null) return;
        new AlertDialog.Builder(mActivity.getApplicationContext()).setMessage(message)
                .setPositiveButton(R.string.action_agree, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request(permission, codeRequest);
                    }
                })
                .setNegativeButton(R.string.action_dis_agree, null)
                .show();
    }

    private boolean isHashPermission(@NonNull String permission) {
        try {
            return ContextCompat.checkSelfPermission(mActivity.getApplicationContext(), permission)
                    == PackageManager.PERMISSION_GRANTED;
        } catch (RuntimeException ex) {
            return false;
        }
    }

    private boolean isShowRequest(@NonNull String permission) {
        return mActivity != null && ActivityCompat.shouldShowRequestPermissionRationale(mActivity,
                permission);
    }

    private void request(@NonNull String permission, int codePermission) {
        if (mActivity == null) return;
        ActivityCompat.requestPermissions(mActivity, new String[] { permission }, codePermission);
    }
}
