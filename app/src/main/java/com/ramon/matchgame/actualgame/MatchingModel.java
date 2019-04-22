package com.ramon.matchgame.actualgame;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ramon.matchgame.BundleKeys;
import com.ramon.matchgame.webservice.flicker.model.FlikerResults;
import com.ramon.matchgame.webservice.flicker.model.Photo;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchingModel {


    private Gson gson;
    private int numOfMatchesMade;
    private List<Photo> photoList;
    private int numofImages = 0;
    private int boardSize = 0;
    private FlikerResults flickerResults;
    private int numofMoves = 0;

    MatchingModel(Intent intent, Gson gson) {
        this.gson = gson;
        retreiveFromIntent(intent, gson);
    }


    List<Photo> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<Photo> photoList) {
        this.photoList = photoList;
    }


    public FlikerResults getFlickerResults() {
        return flickerResults;
    }

    public void setFlickerResults(FlikerResults flickerResults) {
        this.flickerResults = flickerResults;
    }

    int getNumofImages() {
        return numofImages;
    }

    public void setNumofImages(int numofImages) {
        this.numofImages = numofImages;
    }

    int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public MatchingModel() {

    }


    int getNumOfMoves() {
        return numofMoves;
    }

    void incrementMoves() {
        numofMoves++;
    }

    public void setNumofMoves(int numofMoves) {
        this.numofMoves = numofMoves;
    }


    private void retreiveFromIntent(Intent intent, Gson gson) {
        flickerResults = getFlickerData(intent.getStringExtra(BundleKeys.FLICKER_RESULTS_KEY), gson);
        numofImages = intent.getIntExtra(BundleKeys.NUMBER_OF_IMAGES_KEY, 8);
        boardSize = intent.getIntExtra(BundleKeys.BOARD_SIZE_KEY, 4);

    }

    private FlikerResults getFlickerData(String stringExtra, Gson gson) {
        FlikerResults flikerResults = new FlikerResults();
        if (!StringUtils.isEmpty(stringExtra)) {
            flikerResults = gson.fromJson(stringExtra, FlikerResults.class);
            photoList = createActualList(flikerResults.getPhotos().getPhoto());
        }
        return flikerResults;
    }

    private List<Photo> createActualList(List<Photo> photo) {
        List<Photo> returnList = new ArrayList<>(photo);
        returnList.addAll(photo);
        Collections.shuffle(returnList);
        return returnList;
    }

    int getNumOfMatchesMade() {
        return numOfMatchesMade;
    }

    public void setNumOfMatchesMade(int numOfMatchesMade) {
        this.numOfMatchesMade = numOfMatchesMade;
    }

    void incrementMatchMade() {
        numOfMatchesMade++;
    }

    Bundle saveInstace(Bundle outState) {
        outState.putInt(BundleKeys.MATCH_NUM_OF_MOVES, numofMoves);
        outState.putInt(BundleKeys.MATCHES_MADE, numOfMatchesMade);
        outState.putInt(BundleKeys.MATCH_BOARD_SIZE, boardSize);
        outState.putInt(BundleKeys.MATCH_NUM_IMAGES, numofImages);
        outState.putString(BundleKeys.MATCH_FLIK_RESULTS, gson.toJson(flickerResults));
        outState.putString(BundleKeys.MATCH_PHOTO_ARRAY, gson.toJson(photoList));
        return outState;
    }

    void restoreInstance(Bundle restoreState) {
        numOfMatchesMade = restoreState.getInt(BundleKeys.MATCHES_MADE);
        photoList = retreivePhotosFromBundle(restoreState.getString(BundleKeys.MATCH_PHOTO_ARRAY, ""));
        numofImages = restoreState.getInt(BundleKeys.MATCH_NUM_IMAGES);
        boardSize = restoreState.getInt(BundleKeys.MATCH_BOARD_SIZE);
        flickerResults = getFlickerData(restoreState.getString(BundleKeys.MATCH_FLIK_RESULTS, ""), gson);
        numofMoves = restoreState.getInt(BundleKeys.MATCH_NUM_OF_MOVES);

    }

    private List<Photo> retreivePhotosFromBundle(String extraString) {
        List<Photo> photos= new ArrayList<>();
        if (!StringUtils.isEmpty(extraString)){
            photos=gson.fromJson(extraString,new TypeToken<List<Photo>>(){}.getType());
        }
        return photos;
    }
}
