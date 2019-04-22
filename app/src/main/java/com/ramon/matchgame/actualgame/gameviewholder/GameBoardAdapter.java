package com.ramon.matchgame.actualgame.gameviewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ramon.matchgame.actualgame.MatchingPresenter;
import com.ramon.matchgame.webservice.flicker.model.Photo;

import java.util.List;

public class GameBoardAdapter extends RecyclerView.Adapter {

    private final MatchingPresenter presenter;
    private final List<Photo> photoList;

    public GameBoardAdapter(List<Photo> photo, MatchingPresenter presenter) {
        this.photoList=photo;
        this.presenter=presenter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return GameViewHolder.inflate(viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof GameViewHolder){
            ((GameViewHolder) viewHolder).bind(photoList.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

}
