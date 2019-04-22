package com.ramon.matchgame.actualgame.gameviewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ramon.matchgame.actualgame.MatchingPresenter;
import com.ramon.matchgame.webservice.flicker.model.Photo;

import java.util.List;

public class GameBoardAdapter extends RecyclerView.Adapter {

    private MatchingPresenter presenter;
    private List<Photo> photoList;
    private Integer selected=null;
    boolean[] matched;

    public GameBoardAdapter(List<Photo> photo, MatchingPresenter presenter) {
        this.photoList=photo;
        this.presenter=presenter;
        matched= new boolean[photoList.size()];
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return GameViewHolder.inflate(viewGroup,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof GameViewHolder){
            ((GameViewHolder) viewHolder).bind(photoList.get(position),matched[position]||selected!=null&&selected==position);
        }

    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

    private  onItemSelected listener= position -> {
      if (selected==null){
          selected=position;
      }else {
          Photo num1=photoList.get(selected);
          Photo num2=photoList.get(position);
          if (num1.equals(num2)){
              matched[selected]=true;
              matched[position]=true;
              presenter.matchMade();
          }
          selected=position;

      }

      presenter.moveMade();
      notifyDataSetChanged();
    };

    interface onItemSelected{
        void itemSelected(int position);
    }

}
