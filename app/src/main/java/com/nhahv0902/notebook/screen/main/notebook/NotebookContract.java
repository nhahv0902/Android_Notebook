package com.nhahv0902.notebook.screen.main.notebook;

import android.support.annotation.IntDef;
import com.nhahv0902.notebook.screen.BasePresenter;
import com.nhahv0902.notebook.screen.BaseViewModel;

import static com.nhahv0902.notebook.screen.main.notebook.NotebookContract.NotebookDate
        .DAY_OF_MONTH;
import static com.nhahv0902.notebook.screen.main.notebook.NotebookContract.NotebookDate.DAY_OF_WEAK;
import static com.nhahv0902.notebook.screen.main.notebook.NotebookContract.NotebookDate.MONTH;
import static com.nhahv0902.notebook.screen.main.notebook.NotebookContract.NotebookDate.YEAR;

/**
 * This specifies the contract between the view and the presenter.
 */
public interface NotebookContract {
    /**
     * View.
     */
    interface ViewModel extends BaseViewModel<Presenter> {
    }

    /**
     * Presenter.
     */
    interface Presenter extends BasePresenter {
    }

    @IntDef({ DAY_OF_MONTH, DAY_OF_WEAK, MONTH, YEAR })
    @interface NotebookDate {
        int DAY_OF_MONTH = 1;
        int DAY_OF_WEAK = 2;
        int MONTH = 3;
        int YEAR = 4;
    }
}
