package com.nhahv0902.notebook.screen.main.setting;

/**
 * Listens to user actions from the UI ({@link SettingFragment}), retrieves the data and updates
 * the UI as required.
 */
final class SettingPresenter implements SettingContract.Presenter {
    private static final String TAG = SettingPresenter.class.getName();

    private final SettingContract.ViewModel mViewModel;

    public SettingPresenter(SettingContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
