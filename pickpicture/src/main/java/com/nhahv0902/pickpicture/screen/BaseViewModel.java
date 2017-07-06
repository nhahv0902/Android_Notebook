package com.nhahv0902.pickpicture.screen;

/**
 * Created by nhahv0902 on 7/6/17.
 */

public interface BaseViewModel<T> {
    void onStart();

    void onStop();

    void setPresenter(T presenter);
}
