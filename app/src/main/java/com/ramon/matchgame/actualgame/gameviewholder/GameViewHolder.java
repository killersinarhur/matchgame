package com.ramon.matchgame.actualgame.gameviewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.ramon.matchgame.R;
import com.ramon.matchgame.webservice.flicker.FlickerEndpoint;
import com.ramon.matchgame.webservice.flicker.model.Photo;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


class GameViewHolder extends RecyclerView.ViewHolder {
    private final GameBoardAdapter.onItemSelected listener;

    @BindView(R.id.image_match)
    ImageView matchedImages;
    private boolean revealed;

    public GameViewHolder(@NonNull View itemView, GameBoardAdapter.onItemSelected listener) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        this.listener=listener;
    }

    public static GameViewHolder inflate(ViewGroup viewGroup, GameBoardAdapter.onItemSelected listener) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.game_view_holder,viewGroup,false);
        return new GameViewHolder(view,listener);
    }

    public void bind(Photo photo, boolean revealed) {
        this.revealed=revealed;
        if(revealed){
            Glide.with(itemView)
                    .load(FlickerEndpoint.buildImageUrl(photo.getFarm()
                            ,photo.getServer()
                            ,photo.getId()
                            ,photo.getSecret()
                            ,"t","jpeg")).into(matchedImages);

        }else {
            matchedImages.setImageDrawable(itemView.getResources().getDrawable(R.drawable.ic_help_black_24dp));
        }


    }

    @OnClick({R.id.click_area,R.id.more_click_area})
    void itemClicked(){
        if(!revealed)
        listener.itemSelected(getAdapterPosition());
    }
}
