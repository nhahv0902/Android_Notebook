package com.nhahv0902.pickpicture.screen.album;

import com.nhahv0902.pickpicture.data.model.Album;
import com.nhahv0902.pickpicture.screen.BasePresenter;
import com.nhahv0902.pickpicture.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface AlbumContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onStartPickPictureView(Album album);

        void loadPicture();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
