package com.nhahv0902.notebook.screen.main.notebook;

/**
 * Listens to user actions from the UI ({@link NotebookFragment}), retrieves the data and updates
 * the UI as required.
 */
final class NotebookPresenter implements NotebookContract.Presenter {
    private static final String TAG = NotebookPresenter.class.getName();

    private final NotebookContract.ViewModel mViewModel;

    public NotebookPresenter(NotebookContract.ViewModel viewModel) {
        mViewModel = viewModel;
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }
}
