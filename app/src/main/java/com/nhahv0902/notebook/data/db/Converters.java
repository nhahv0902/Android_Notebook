package com.nhahv0902.notebook.data.db;

import android.arch.persistence.room.TypeConverter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nhahv0902 on 7/6/17.
 * <></>
 */

public class Converters {
    @TypeConverter
    public static String arrayPictureToString(List<String> pictures) {
        return new Gson().toJson(pictures);
    }

    @TypeConverter
    public static List<String> pictureToArray(String pictures) {
        return new Gson().fromJson(pictures, new TypeToken<ArrayList<String>>() {
        }.getType());
    }
}
