package com.nhahv0902.notebook.screen.login;

import com.nhahv0902.notebook.screen.BasePresenter;
import com.nhahv0902.notebook.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface LoginContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onFacebookStartMain();

        void onGoogleStartMain();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
        void onStart();

        void onStop();
    }
}
