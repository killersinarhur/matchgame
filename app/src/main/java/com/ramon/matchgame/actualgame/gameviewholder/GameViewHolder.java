package com.ramon.matchgame.actualgame.gameviewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramon.matchgame.R;
import com.ramon.matchgame.webservice.flicker.model.Photo;


class GameViewHolder extends RecyclerView.ViewHolder {

    public GameViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public static GameViewHolder inflate(ViewGroup viewGroup) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_view_holder,viewGroup,false);
        return new GameViewHolder(view);
    }

    public void bind(Photo photo) {

    }
}
