package com.nhahv0902.notebook.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by nhahv0902 on 7/6/17.
 * <></>
 */

public class SharedPrefs {
    private static final String PREFS_NAME = "note_book";
    private static SharedPrefs sInstance;
    private SharedPreferences mPreferences;

    private SharedPrefs(Context context) {
        mPreferences = context.getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
    }

    public static SharedPrefs getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SharedPrefs(context);
        }
        return sInstance;
    }

    @SuppressWarnings("unchecked")
    public <T> T get(@NonNull String key, Class<T> tClass) {
        if (tClass == String.class) {
            return (T) mPreferences.getString(key, "");
        } else if (tClass == Boolean.class) {
            return (T) Boolean.valueOf(mPreferences.getBoolean(key, false));
        } else if (tClass == Long.class) {
            return (T) Long.valueOf(mPreferences.getLong(key, 0));
        } else if (tClass == Integer.class) {
            return (T) Integer.valueOf(mPreferences.getInt(key, 0));
        } else if (tClass == Float.class) {
            return (T) Float.valueOf(mPreferences.getFloat(key, 0));
        }
        return null;
    }

    public <T> void put(@NonNull String key, T data) {
        SharedPreferences.Editor editor = mPreferences.edit();
        if (data instanceof String) {
            editor.putString(key, (String) data);
        } else if (data instanceof Boolean) {
            editor.putBoolean(key, (Boolean) data);
        } else if (data instanceof Long) {
            editor.putLong(key, (Long) data);
        } else if (data instanceof Integer) {
            editor.putInt(key, (Integer) data);
        } else if (data instanceof Float) {
            editor.putFloat(key, (Float) data);
        }
        editor.apply();
    }

    public void clear() {
        mPreferences.edit().clear().apply();
    }

    public void remove(@NonNull String key) {
        if (mPreferences.contains(key)) {
            mPreferences.edit().remove(key).apply();
        }
    }

    public static class SharedPrefKey {
        public static final String PREF_IS_LOGIN = "PREF_IS_LOGIN";
    }
}
