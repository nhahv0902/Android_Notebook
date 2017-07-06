package com.nhahv0902.pickpicture.screen.album;

/**
 * Listens to user actions from the UI ({@link AlbumActivity}), retrieves the data and updates
 * the UI as required.
 */
final class AlbumPresenter implements AlbumContract.Presenter {
    private static final String TAG = AlbumPresenter.class.getName();

    private final AlbumContract.ViewModel mViewModel;
    public AlbumPresenter(AlbumContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
