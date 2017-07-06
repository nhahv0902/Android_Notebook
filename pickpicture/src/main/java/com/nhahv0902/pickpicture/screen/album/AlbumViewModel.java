package com.nhahv0902.pickpicture.screen.album;

import android.Manifest;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.nhahv0902.pickpicture.BR;
import com.nhahv0902.pickpicture.R;
import com.nhahv0902.pickpicture.data.model.Album;
import com.nhahv0902.pickpicture.util.LoadLocalPictureManager;
import com.nhahv0902.pickpicture.util.Navigator;
import com.nhahv0902.pickpicture.util.Permissions;
import java.util.ArrayList;
import java.util.List;

import static com.nhahv0902.pickpicture.screen.album.AlbumActivity.PERMISSION_READ_STORAGE;

/**
 * Exposes the data to be used in the Album screen.
 */

public class AlbumViewModel extends BaseObservable implements AlbumContract.ViewModel {

    private final Navigator mNavigator;
    private final LoadLocalPictureManager mLoadPictureManager;
    private AlbumContract.Presenter mPresenter;
    private AlbumAdapter mAdapter;
    private List<Album> mAlbums = new ArrayList<>();
    private boolean mIsLoaded;

    public AlbumViewModel(LoadLocalPictureManager loadLocalPictureManager, Navigator navigator,
            Permissions permissions) {
        mAdapter = new AlbumAdapter(this, mAlbums);
        mNavigator = navigator;
        mLoadPictureManager = loadLocalPictureManager;
        if (permissions.requestPermission(Manifest.permission.READ_EXTERNAL_STORAGE,
                PERMISSION_READ_STORAGE, R.string.request_storage_permission)) {
            loadPicture();
        }
    }

    @Override
    public void loadPicture() {
        if (mLoadPictureManager != null) {
            mLoadPictureManager.loadAllAlbum(new LoadLocalPictureManager.LoadPictureCallback() {
                @Override
                public void onLoadPictureSuccess(List<Album> albums) {
                    setLoaded(true);
                    mAlbums.clear();
                    mAlbums.addAll(albums);
                    getAdapter().notifyDataSetChanged();
                }

                @Override
                public void onLoadPictureFails() {
                    mNavigator.log("load fails");
                    setLoaded(true);
                }
            });
        }
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(AlbumContract.Presenter presenter) {
        mPresenter = presenter;
    }

    /*
    * function of ViewModel
    * */

    @Override
    public void onStartPickPictureView(Album album) {
    }

    /*
        * set get of variable
        * */
    @Bindable
    public AlbumAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(AlbumAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    @Bindable
    public boolean isLoaded() {
        return mIsLoaded;
    }

    public void setLoaded(boolean loaded) {
        mIsLoaded = loaded;
        notifyPropertyChanged(BR.loaded);
    }
}
