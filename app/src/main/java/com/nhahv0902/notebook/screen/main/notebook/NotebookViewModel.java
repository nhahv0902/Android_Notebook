package com.nhahv0902.notebook.screen.main.notebook;

import android.databinding.BaseObservable;

/**
 * Exposes the data to be used in the Notebook screen.
 */

public class NotebookViewModel extends BaseObservable implements NotebookContract.ViewModel {

    private NotebookContract.Presenter mPresenter;

    public NotebookViewModel() {
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
    public void setPresenter(NotebookContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
