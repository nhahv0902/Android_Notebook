package com.nhahv0902.pickpicture.util;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.annotation.NonNull;

import com.nhahv0902.pickpicture.data.model.Album;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nhahv0902 on 7/8/2017.
 * <></>
 */

public class LoadLocalPictureManager {

    private final String[] SELECTION_ARGS = new String[]{"image/jpeg", "image/png"};
    private final String MIME_TYPE = MediaStore.Images.Media.MIME_TYPE;
    private final String SELECTION = MIME_TYPE + "=? or " + MIME_TYPE + "=?";
    private final String[] IMAGE_PROJECTION = new String[]{MediaStore.Images.Media.DATA,
            MediaStore.Images.Media.DISPLAY_NAME, MediaStore.Images.Media.DATE_ADDED,
            MediaStore.Images.ImageColumns.BUCKET_DISPLAY_NAME};
    private final Context mContext;

    public LoadLocalPictureManager(@NonNull Context context) {
        mContext = context;
    }

    public void loadAllAlbum(@NonNull LoadPictureCallback callback) {
        Cursor cursor = mContext.getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_PROJECTION, SELECTION,
                SELECTION_ARGS, IMAGE_PROJECTION[2] + " DESC", null);

        if (cursor == null || !cursor.moveToFirst()) {
            callback.onLoadPictureFails();
            return;
        }
        int indexPath = cursor.getColumnIndex(IMAGE_PROJECTION[0]);
        int indexFolder = cursor.getColumnIndex(IMAGE_PROJECTION[3]);
        String albumName;
        String imagePath;
        Map<String, Album> hashAlbum = new HashMap<>();

        while (!cursor.isAfterLast()) {
            albumName = cursor.getString(indexFolder);
            imagePath = cursor.getString(indexPath);

            if (!hashAlbum.containsKey(albumName)) {
                hashAlbum.put(albumName, new Album(albumName));
            }
            hashAlbum.get(albumName).getPictures().add(imagePath);
            cursor.moveToNext();
        }
        cursor.close();
        List<Album> albums = new ArrayList<>(hashAlbum.values());
        callback.onLoadPictureSuccess(albums);
    }

    public interface LoadPictureCallback {
        void onLoadPictureSuccess(List<Album> albums);

        void onLoadPictureFails();
    }
}
