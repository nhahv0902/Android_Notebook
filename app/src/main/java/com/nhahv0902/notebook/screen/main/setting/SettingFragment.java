package com.nhahv0902.notebook.screen.main.setting;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhahv0902.notebook.R;
import com.nhahv0902.notebook.databinding.FragmentSettingBinding;
import com.nhahv0902.notebook.screen.BaseFragment;

/**
 * Setting Screen.
 */
public class SettingFragment extends BaseFragment {

    private SettingContract.ViewModel mViewModel;

    public static SettingFragment newInstance() {
        return new SettingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new SettingViewModel();

        SettingContract.Presenter presenter = new SettingPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentSettingBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_setting, container, false);
        binding.setViewModel((SettingViewModel) mViewModel);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        mViewModel.onStart();
    }

    @Override
    public void onStop() {
        mViewModel.onStop();
        super.onStop();
    }
}
