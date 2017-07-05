package com.nhahv0902.notebook.screen.login;


/**
 * Exposes the data to be used in the Login screen.
 */

public class LoginViewModel implements LoginContract.ViewModel {

    private LoginContract.Presenter mPresenter;

    public LoginViewModel() {
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
    public void setPresenter(LoginContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
