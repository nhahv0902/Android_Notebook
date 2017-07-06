package com.nhahv0902.notebook.screen.main.setting;

import android.databinding.BaseObservable;

/**
 * Exposes the data to be used in the Setting screen.
 */

public class SettingViewModel extends BaseObservable implements SettingContract.ViewModel {

    private SettingContract.Presenter mPresenter;

    public SettingViewModel() {
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
    public void setPresenter(SettingContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
