package com.nhahv0902.notebook.screen;

/**
 * Created by nhahv0902 on 7/4/17.
 * <<></>
 */

public interface BaseViewModel<T> {
    void setPresenter(T presenter);

    void onStart();

    void onStop();
}
