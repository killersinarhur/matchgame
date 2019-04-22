package com.ramon.matchgame.startgame;

import android.os.Bundle;

public class StartGameModel {
    public static final String NUMS_KEY="START_NUMS_KEY";
    public static final String BOARD_KEY="START_BOARD_KEY";
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
        outState.putInt(NUMS_KEY,numOfImages);
        outState.putInt(BOARD_KEY,(int)boardSize);
        return outState;
    }

    public void restoreState(Bundle savedInstanceState) {
        numOfImages=savedInstanceState.getInt(NUMS_KEY);
        boardSize=savedInstanceState.getInt(BOARD_KEY);
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
