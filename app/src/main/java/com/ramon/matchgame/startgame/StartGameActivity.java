package com.ramon.matchgame.startgame;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.ramon.matchgame.R;
import com.ramon.matchgame.actualgame.MatchingActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartGameActivity extends AppCompatActivity implements StartGamePresenter.View {
    @BindView(R.id.num_unique_images)
    TextView numofImages;
    @BindView(R.id.board_size)
    TextView boardSize;
    @BindView(R.id.left_carrot_image)
    TextView leftCarrot;
    @BindView(R.id.right_carrot_image)
    TextView rightCarrot;
    private StartGamePresenter presenter;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        ButterKnife.bind(this);
        presenter= new StartGamePresenter(this,new StartGameModel());
        dialog=initDialog();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.viewCreated();
    }

    private ProgressDialog initDialog() {
        ProgressDialog dialog=new ProgressDialog(this);
        dialog.setMessage("Please Wait While we create your game");
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setIndeterminate(true);
        return dialog;
    }

    @OnClick(R.id.left_carrot_image)
    public void decreaseSize(){
        presenter.decreaseBoardSize();

    }

    @OnClick(R.id.right_carrot_image)
    public void increaseSize(){
        presenter.increaseBoardSize();
    }

    @OnClick(R.id.start_game_btn)
    public void startGame(){
        presenter.serviceCallStarted();
    }

    @Override
    public void updateBoardSize(int size, double boardSizeNum) {
        numofImages.setText(getString(R.string.unique_images,size));
        boardSize.setText(getString(R.string.board_size,(int)boardSizeNum,(int)boardSizeNum));

    }

    @Override
    public void showProgressDialog() {
        dialog.show();
    }

    @Override
    public void hideProgressDialog() {
        dialog.dismiss();
    }

    @Override
    public void toggleIncrease(boolean b) {
        rightCarrot.setEnabled(b);
    }

    @Override
    public void toggleDecrease(boolean b) {
        leftCarrot.setEnabled(b);
    }

    @Override
    public void launchGame(String flikerResults, int numOfImages, int boardSize) {
        Intent intent= new Intent(this, MatchingActivity.class);
        intent.putExtra(MatchingActivity.FLICKER_RESULTS_KEY,flikerResults);
        intent.putExtra(MatchingActivity.NUMBER_OF_IMAGES_KEY,numOfImages);
        intent.putExtra(MatchingActivity.BOARD_SIZE_KEY,boardSize);
        startActivity(intent);
    }

    @Override
    public void showErrorState() {
        Toast.makeText(this,"error",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
       outState= presenter.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        presenter.restoreState(savedInstanceState);
    }
}
