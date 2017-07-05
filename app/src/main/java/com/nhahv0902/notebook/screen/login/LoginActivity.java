package com.nhahv0902.notebook.screen.login;

import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.nhahv0902.notebook.R;
import com.nhahv0902.notebook.databinding.ActivityLoginBinding;
import com.nhahv0902.notebook.screen.BaseActivity;

/**
 * Login Screen.
 */
public class LoginActivity extends BaseActivity {

    private LoginContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new LoginViewModel();

        LoginContract.Presenter presenter =
                new LoginPresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        ActivityLoginBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewModel((LoginViewModel) mViewModel);
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
}
