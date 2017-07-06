package com.nhahv0902.notebook.screen.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import com.nhahv0902.notebook.BR;
import com.nhahv0902.notebook.screen.main.notebook.NotebookFragment;
import com.nhahv0902.notebook.screen.main.setting.SettingFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Exposes the data to be used in the Main screen.
 */

public class MainViewModel extends BaseObservable implements MainContract.ViewModel {

    private MainContract.Presenter mPresenter;
    private ViewPagerAdapter mAdapter;
    private int mCurrentViewPager;

    public MainViewModel(FragmentManager fragmentManager) {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(NotebookFragment.newInstance());
        fragments.add(SettingFragment.newInstance());
        mAdapter = new ViewPagerAdapter(fragmentManager, fragments);
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
    public void setPresenter(MainContract.Presenter presenter) {
        mPresenter = presenter;
    }
    /*
    *  function in ViewModel
    * */

    @Override
    public void onStartNewNote() {

    }

    /*
    * get set of variable
    * */
    @Bindable
    public ViewPagerAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(ViewPagerAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }

    @Bindable
    public int getCurrentViewPager() {
        return mCurrentViewPager;
    }

    public void setCurrentViewPager(int currentViewPager) {
        mCurrentViewPager = currentViewPager;
        notifyPropertyChanged(BR.currentViewPager);
    }
}
