package com.nhahv0902.pickpicture.screen.album;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nhahv0902.pickpicture.R;
import com.nhahv0902.pickpicture.data.model.Album;
import com.nhahv0902.pickpicture.databinding.ItemActivityAlbumBinding;

import java.util.List;

/**
 * Created by nhahv0902 on 7/8/2017.
 * <></>
 */

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumHolder> {
    private List<Album> mAlbums;
    private AlbumViewModel mViewModel;
    private LayoutInflater mInflater;

    public AlbumAdapter(AlbumViewModel viewModel, List<Album> albums) {
        mAlbums = albums;
        mViewModel = viewModel;
    }

    @Override
    public AlbumHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mInflater == null) mInflater = LayoutInflater.from(parent.getContext());
        ItemActivityAlbumBinding binding = DataBindingUtil.inflate(mInflater, R.layout.item_activity_album, parent, false);
        binding.setViewModel(mViewModel);
        return new AlbumHolder(binding);
    }

    @Override
    public void onBindViewHolder(AlbumHolder holder, int position) {
        if (mAlbums.get(position) != null) {
            holder.bind(mAlbums.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        return mAlbums == null ? 0 : mAlbums.size();
    }

    class AlbumHolder extends RecyclerView.ViewHolder {

        private final ItemActivityAlbumBinding mBinding;

        public AlbumHolder(ItemActivityAlbumBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        private void bind(@NonNull Album album, int position) {
            mBinding.setAlbum(album);
            mBinding.setPosition(position);
            mBinding.executePendingBindings();
        }
    }
}
