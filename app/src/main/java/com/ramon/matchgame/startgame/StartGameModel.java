package com.ramon.matchgame.startgame;

import android.os.Bundle;

import com.ramon.matchgame.BundleKeys;

import java.util.Random;

public class StartGameModel {

    public int getPageNumber() {
        Random random= new Random();
        return random.nextInt(pageNumber);
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int pageNumber=5;
    private int numOfImages = UniqueImages.SMALL;
    private double boardSize = 4;

    public void increaseSize() {
        int result = 0;
        switch (numOfImages) {
            case UniqueImages.SMALL:
                result=UniqueImages.MEDIUM;
                break;
            case UniqueImages.MEDIUM:
                result=UniqueImages.LARGE;
                break;
            case UniqueImages.LARGE:
                break;
        }
        setNumOfImages(result);
    }

    public void decreaseSize() {
        int result = 0;
        switch (numOfImages) {
            case UniqueImages.SMALL:
                break;
            case UniqueImages.MEDIUM:
                result=UniqueImages.SMALL;
                break;
            case UniqueImages.LARGE:
                result=UniqueImages.MEDIUM;
                break;
        }

        setNumOfImages(result);
    }

    public Bundle saveInstance(Bundle outState) {
        outState.putInt(BundleKeys.START_NUMS_KEY,numOfImages);
        outState.putInt(BundleKeys.START_BOARD_KEY,(int)boardSize);
        return outState;
    }

    public void restoreState(Bundle savedInstanceState) {
        numOfImages=savedInstanceState.getInt(BundleKeys.START_NUMS_KEY);
        boardSize=savedInstanceState.getInt(BundleKeys.START_BOARD_KEY);
    }


    public @interface UniqueImages {
        int SMALL = 8;
        int MEDIUM = 18;
        int LARGE = 32;
    }

    public int getNumOfImages() {
        return numOfImages;
    }

    public void setNumOfImages(int numOfImages) {
        this.numOfImages = numOfImages;
        setBoardSize(Math.sqrt(numOfImages * 2));
    }

    public double getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(double boardSize) {
        this.boardSize = boardSize;
    }
}
