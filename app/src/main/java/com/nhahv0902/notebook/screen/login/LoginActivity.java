package com.nhahv0902.notebook.screen.login;

import android.databinding.DataBindingUtil;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import com.nhahv0902.notebook.R;
import com.nhahv0902.notebook.databinding.ActivityLoginBinding;
import com.nhahv0902.notebook.screen.BaseActivity;
import com.nhahv0902.notebook.util.Navigator;
import com.nhahv0902.notebook.util.SharedPrefs;

/**
 * Login Screen.
 */
public class LoginActivity extends BaseActivity {

    private LoginContract.ViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new LoginViewModel(new Navigator(this),
                SharedPrefs.getInstance(getApplicationContext()));

        LoginContract.Presenter presenter = new LoginPresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        ActivityLoginBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setViewModel((LoginViewModel) mViewModel);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (getWindow() != null) {
                getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
            }
        }
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
