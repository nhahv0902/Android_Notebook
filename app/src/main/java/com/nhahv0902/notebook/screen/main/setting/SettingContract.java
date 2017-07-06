package com.nhahv0902.notebook.screen.main.setting;

import com.nhahv0902.notebook.screen.BasePresenter;
import com.nhahv0902.notebook.screen.BaseViewModel;

/**
 * This specifies the contract between the view and the presenter.
 */
interface SettingContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }
}
