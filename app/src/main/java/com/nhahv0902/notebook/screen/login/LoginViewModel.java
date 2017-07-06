package com.nhahv0902.notebook.screen.login;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Handler;
import com.nhahv0902.notebook.BR;
import com.nhahv0902.notebook.screen.main.MainActivity;
import com.nhahv0902.notebook.util.Navigator;
import com.nhahv0902.notebook.util.SharedPrefs;

import static com.nhahv0902.notebook.util.ConstantUtils.TimeUtil.TIME_DELAY;
import static com.nhahv0902.notebook.util.SharedPrefs.SharedPrefKey.PREF_IS_LOGIN;

/**
 * Exposes the data to be used in the Login screen.
 */

public class LoginViewModel extends BaseObservable implements LoginContract.ViewModel {

    private LoginContract.Presenter mPresenter;
    private final Navigator mNavigator;
    private SharedPrefs mSharedPrefs;
    private boolean mIsViewLogin;

    public LoginViewModel(Navigator navigator, SharedPrefs sharedPrefs) {
        mNavigator = navigator;
        mSharedPrefs = sharedPrefs;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean isLogin = mSharedPrefs.get(PREF_IS_LOGIN, Boolean.class);
                if (isLogin) {
                    mNavigator.startActivity(MainActivity.newIntent(mNavigator.getContext()));
                } else {
                    setViewLogin(true);
                }
            }
        }, TIME_DELAY);
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

    @Override
    public void onFacebookStartMain() {
        mNavigator.startActivity(MainActivity.newIntent(mNavigator.getContext()));
    }

    @Override
    public void onGoogleStartMain() {
        mNavigator.startActivity(MainActivity.newIntent(mNavigator.getContext()));
    }

    @Bindable
    public boolean isViewLogin() {
        return mIsViewLogin;
    }

    public void setViewLogin(boolean viewLogin) {
        mIsViewLogin = viewLogin;
        notifyPropertyChanged(BR.viewLogin);
    }
}
