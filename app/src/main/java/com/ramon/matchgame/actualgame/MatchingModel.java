package com.ramon.matchgame.actualgame;

import android.content.Intent;

import com.google.gson.Gson;
import com.ramon.matchgame.webservice.flicker.model.FlikerResults;
import com.ramon.matchgame.webservice.flicker.model.Photo;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.ramon.matchgame.actualgame.MatchingActivity.BOARD_SIZE_KEY;
import static com.ramon.matchgame.actualgame.MatchingActivity.FLICKER_RESULTS_KEY;
import static com.ramon.matchgame.actualgame.MatchingActivity.NUMBER_OF_IMAGES_KEY;

public class MatchingModel {

    private int numOfMatchesMade;

    public MatchingModel(Intent intent, Gson gson) {
        retreiveFromIntent(intent, gson);
    }

    private FlikerResults flickerResults;

    public List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }

    private List<Photo> photoList;
    private int numofImages = 0;
    private int boardSize = 0;

    private int numofMoves = 0;

    public FlikerResults getFlickerResults() {
        return flickerResults;
    }

    public void setFlickerResults(FlikerResults flickerResults) {
        this.flickerResults = flickerResults;
    }

    public int getNumofImages() {
        return numofImages;
    }

    public void setNumofImages(int numofImages) {
        this.numofImages = numofImages;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public MatchingModel() {

    }


    public int getNumOfMoves() {
        return numofMoves;
    }

    public void incrementMoves() {
        numofMoves++;
    }

    public void setNumofMoves(int numofMoves) {
        this.numofMoves = numofMoves;
    }


    private void retreiveFromIntent(Intent intent, Gson gson) {
        flickerResults = getFlickerData(intent.getStringExtra(FLICKER_RESULTS_KEY), gson);
        numofImages = intent.getIntExtra(NUMBER_OF_IMAGES_KEY, 8);
        boardSize = intent.getIntExtra(BOARD_SIZE_KEY, 4);

    }

    private FlikerResults getFlickerData(String stringExtra, Gson gson) {
        FlikerResults flikerResults = new FlikerResults();
        if (!StringUtils.isEmpty(stringExtra)) {
            flikerResults = gson.fromJson(stringExtra, FlikerResults.class);
           photoList= createActualList(flikerResults.getPhotos().getPhoto());
        }
        return flikerResults;
    }

    private List<Photo> createActualList(List<Photo> photo) {
        List<Photo> returnList= new ArrayList<>(photo);
        returnList.addAll(photo);
        Collections.shuffle(returnList);
        return returnList;
    }

    public int getNumOfMatchesMade() {
        return numOfMatchesMade;
    }

    public void setNumOfMatchesMade(int numOfMatchesMade) {
        this.numOfMatchesMade = numOfMatchesMade;
    }

    public void incrementMatchMade() {
        numOfMatchesMade++;
    }
}
