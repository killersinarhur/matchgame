package com.ramon.matchgame.actualgame;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.ramon.matchgame.BaseApplication;
import com.ramon.matchgame.webservice.flicker.model.Photo;

import java.util.List;

import javax.inject.Inject;

public class MatchingPresenter {

    private MatchingModel model;
    private final View view;

    @Inject
    Gson gson;

     MatchingPresenter(View view, Intent intent) {
        BaseApplication.getDaggerComponent().inject(this);
        this.view = view;
        this.model = new MatchingModel(intent, gson);
    }

    public void moveMade() {
        model.incrementMoves();
        view.incrementMoveCounter(model.getNumOfMoves());
    }

     void onViewCreated() {

        view.initializeView(model.getBoardSize(),model.getPhotoList(),model.getNumOfMoves());
    }

    public void matchMade() {
        model.incrementMatchMade();
        if (model.getNumofImages()==model.getNumOfMatchesMade()){
            view.showGameWon(model.getNumOfMoves());
        }
    }

     Bundle saveState(Bundle outState) {
        return model.saveInstace(outState);
    }

    void restoreState(Bundle restoreState){
         model.restoreInstance(restoreState);
    }

    public interface View {
        void incrementMoveCounter(int numOfMoves);

        void initializeView(int boardSize, List<Photo> photo, int numOfMoves);

        void showGameWon(int numOfMoves);
    }
}
