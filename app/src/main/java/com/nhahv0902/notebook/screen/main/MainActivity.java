package com.nhahv0902.notebook.screen.main;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.nhahv0902.notebook.R;
import com.nhahv0902.notebook.databinding.ActivityMainBinding;
import com.nhahv0902.notebook.screen.BaseActivity;

/**
 * Main Screen.
 */
public class MainActivity extends BaseActivity {

    private MainContract.ViewModel mViewModel;

    public static Intent newIntent(Context context) {
        return new Intent(context, MainActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel = new MainViewModel(getSupportFragmentManager());

        MainContract.Presenter presenter = new MainPresenter(mViewModel);
        mViewModel.setPresenter(presenter);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel((MainViewModel) mViewModel);
    }

/*
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_notebook:
                    return true;
                case R.id.navigation_new_notebook:
                    return true;
                case R.id.navigation_setting:
                    return true;
            }
            return false;
        }
    };*/

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
