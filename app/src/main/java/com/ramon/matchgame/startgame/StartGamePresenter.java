package com.ramon.matchgame.startgame;

import com.google.gson.Gson;
import com.ramon.matchgame.BaseApplication;
import com.ramon.matchgame.webservice.flicker.FlickerClient;
import com.ramon.matchgame.webservice.flicker.callback.PhotoCallBack;
import com.ramon.matchgame.webservice.flicker.model.FlikerResults;

import javax.inject.Inject;

public class StartGamePresenter implements PhotoCallBack {

    @Inject
    FlickerClient flickerClient;
    @Inject
    Gson gson;
    private StartGameModel model;
    private View view;

    public StartGamePresenter(View view, StartGameModel model) {
        this.view= view;
        this.model=model;
        BaseApplication.getDaggerComponent().inject(this);
    }


    public void decreaseBoardSize() {
        model.decreaseSize();
        view.updateBoardSize(model.getNumOfImages(),model.getBoardSize());
        view.toggleDecrease(!(model.getNumOfImages()== StartGameModel.UniqueImages.SMALL));
        view.toggleIncrease(!(model.getNumOfImages()== StartGameModel.UniqueImages.LARGE));
    }

    public void increaseBoardSize() {
        model.increaseSize();
        view.updateBoardSize(model.getNumOfImages(),model.getBoardSize());
        view.toggleDecrease(!(model.getNumOfImages()== StartGameModel.UniqueImages.SMALL));
        view.toggleIncrease(!(model.getNumOfImages()== StartGameModel.UniqueImages.LARGE));
    }

    public void viewCreated() {
        view.updateBoardSize(model.getNumOfImages(),model.getBoardSize());
        view.toggleDecrease(false);

    }

    public void serviceCallStarted() {
        view.showProgressDialog();
        flickerClient.getPhotos(this,model.getNumOfImages());
    }

    @Override
    public void onPhotosSuccess(FlikerResults flikerResults) {
        view.hideProgressDialog();
        view.launchGame(gson.toJson(flikerResults),model.getNumOfImages(),(int)model.getBoardSize());
    }

    @Override
    public void onPhotosFailure(int code, String message) {
        view.hideProgressDialog();
        view.showErrorState();
    }

    public interface View{
        void updateBoardSize(int size, double boardSize);
        void showProgressDialog();
        void hideProgressDialog();

        void toggleIncrease(boolean b);

        void toggleDecrease(boolean b);

        void launchGame(String flikerResults, int numOfImages, int boardSize);

        void showErrorState();

    }
}
