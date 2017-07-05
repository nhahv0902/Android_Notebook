package com.nhahv0902.notebook.screen.main;

import com.nhahv0902.notebook.screen.BasePresenter;
import com.nhahv0902.notebook.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface MainContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
        void onStartNewNote();
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
