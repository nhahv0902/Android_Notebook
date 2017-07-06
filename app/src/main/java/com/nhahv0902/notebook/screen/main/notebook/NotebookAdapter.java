package com.nhahv0902.notebook.screen.main.notebook;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.nhahv0902.notebook.data.db.entity.Notebook;
import com.nhahv0902.notebook.databinding.ItemFragmentNotebookBinding;
import java.util.List;

/**
 * Created by nhahv0902 on 7/6/17.
 * <></>
 */

public class NotebookAdapter extends RecyclerView.Adapter<NotebookAdapter.NotebookHolder> {

    private final NotebookViewModel mViewModel;
    private List<Notebook> mNotebooks;
    private LayoutInflater mInflater;

    public NotebookAdapter(NotebookViewModel viewModel, List<Notebook> notebooks) {
        mNotebooks = notebooks;
        mViewModel = viewModel;
    }

    @Override
    public NotebookHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mInflater == null) mInflater = LayoutInflater.from(parent.getContext());
        ItemFragmentNotebookBinding binding =
                ItemFragmentNotebookBinding.inflate(mInflater, parent, false);
        binding.setViewModel(mViewModel);
        return new NotebookHolder(binding);
    }

    @Override
    public void onBindViewHolder(NotebookHolder holder, int position) {
        if (mNotebooks.get(position) != null) holder.bind(mNotebooks.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mNotebooks == null ? 0 : mNotebooks.size();
    }

    class NotebookHolder extends RecyclerView.ViewHolder {
        private final ItemFragmentNotebookBinding mBinding;

        public NotebookHolder(ItemFragmentNotebookBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        private void bind(@NonNull Notebook notebook, int position) {
            mBinding.setNotebook(notebook);
            mBinding.setPosition(position);
            mBinding.executePendingBindings();
        }
    }
}
