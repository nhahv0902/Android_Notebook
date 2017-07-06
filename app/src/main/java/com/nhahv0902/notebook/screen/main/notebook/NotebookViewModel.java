package com.nhahv0902.notebook.screen.main.notebook;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import com.android.databinding.library.baseAdapters.BR;
import com.nhahv0902.notebook.data.db.entity.Notebook;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exposes the data to be used in the Notebook screen.
 */

public class NotebookViewModel extends BaseObservable implements NotebookContract.ViewModel {

    private NotebookContract.Presenter mPresenter;
    private NotebookAdapter mAdapter;
    private List<Notebook> mNotebooks = new ArrayList<>();

    public NotebookViewModel() {
        mNotebooks.add(new Notebook(13, "wewewqe", "ngay buon thang nho nam bo vo",
                "this color palette comprises primary and accent colors that can be used for "
                        + "illustration or to develop your brand colors. They’ve been designed to"
                        + " work harmoniously with each other. The color palette starts with "
                        + "primary colors and fills in the spectrum to create a complete and "
                        + "usable palette for Android, Web, and iOS. Google suggests using the "
                        + "500 colors as the primary colors in your app and the other colors as "
                        + "accents colors.", "Haf Noi", System.currentTimeMillis(), "4:20 PM",
                Arrays.asList(
                        "http://i2.cdn.cnn"
                                + ".com/cnnnext/dam/assets/161201115958-68-year-in-pictures-2016"
                                + "-restricted-super-169.jpg",
                        "http://i2.cdn.cnn"
                                + ".com/cnnnext/dam/assets/161201115958-68-year-in-pictures-2016"
                                + "-restricted-super-169.jpg")));
        mNotebooks.add(new Notebook(13, "wewewqe", "ngay buon thang nho nam bo vo",
                "this color palette comprises primary and accent colors that can be used for "
                        + "illustration or to develop your brand colors. They’ve been designed to"
                        + " work harmoniously with each other. The color palette starts with "
                        + "primary colors and fills in the spectrum to create a complete and "
                        + "usable palette for Android, Web, and iOS. Google suggests using the "
                        + "500 colors as the primary colors in your app and the other colors as "
                        + "accents colors.", "Haf Noi", System.currentTimeMillis(), "4:20 PM",
                Arrays.asList(
                        "http://i2.cdn.cnn"
                                + ".com/cnnnext/dam/assets/161201115958-68-year-in-pictures-2016"
                                + "-restricted-super-169.jpg",
                        "http://i2.cdn.cnn"
                                + ".com/cnnnext/dam/assets/161201115958-68-year-in-pictures-2016"
                                + "-restricted-super-169.jpg")));

        mAdapter = new NotebookAdapter(this, mNotebooks);
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
    public void setPresenter(NotebookContract.Presenter presenter) {
        mPresenter = presenter;
    }

    /*
    * function of ViewModel
    * */

    /*
    * set get of variable
    * */
    @Bindable
    public NotebookAdapter getAdapter() {
        return mAdapter;
    }

    public void setAdapter(NotebookAdapter adapter) {
        mAdapter = adapter;
        notifyPropertyChanged(BR.adapter);
    }
}
