package com.nhahv0902.notebook.screen.main.notebook;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nhahv0902.notebook.R;
import com.nhahv0902.notebook.databinding.FragmentNotebookBinding;
import com.nhahv0902.notebook.screen.BaseFragment;

/**
 * Notebook Screen.
 */
public class NotebookFragment extends BaseFragment {

    private NotebookContract.ViewModel mViewModel;

    public static NotebookFragment newInstance() {
        return new NotebookFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new NotebookViewModel();

        NotebookContract.Presenter presenter = new NotebookPresenter(mViewModel);
        mViewModel.setPresenter(presenter);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {

        FragmentNotebookBinding binding =
                DataBindingUtil.inflate(inflater, R.layout.fragment_notebook, container, false);
        binding.setViewModel((NotebookViewModel) mViewModel);
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
