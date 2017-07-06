package com.nhahv0902.pickpicture.screen.album;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import com.nhahv0902.pickpicture.R;
import com.nhahv0902.pickpicture.databinding.ActivityAlbumBinding;
import com.nhahv0902.pickpicture.screen.BaseActivity;
import com.nhahv0902.pickpicture.util.LoadLocalPictureManager;
import com.nhahv0902.pickpicture.util.Navigator;
import com.nhahv0902.pickpicture.util.Permissions;

/**
 * Album Screen.
 */
public class AlbumActivity extends BaseActivity {

    public static final int PERMISSION_READ_STORAGE = 1;
    private AlbumContract.ViewModel mViewModel;

    public static Intent newIntent(Context context) {
        return new Intent(context, AlbumActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new AlbumViewModel(new LoadLocalPictureManager(this), new Navigator(this),
                new Permissions(this));

        AlbumContract.Presenter presenter = new AlbumPresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        ActivityAlbumBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_album);
        binding.setViewModel((AlbumViewModel) mViewModel);

        setSupportActionBar(binding.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        setTitle(R.string.title_albums);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    protected void onStop() {
        mViewModel.onStop();
        super.onStop();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
            @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_READ_STORAGE
                && grantResults.length > 0
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mViewModel.loadPicture();
        } else {
            new Navigator(this).toast(R.string.request_denied_read_storage);
        }
    }
}
