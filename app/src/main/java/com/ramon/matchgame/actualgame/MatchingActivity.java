package com.ramon.matchgame.actualgame;

import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ramon.matchgame.BundleKeys;
import com.ramon.matchgame.R;
import com.ramon.matchgame.actualgame.gameviewholder.GameBoardAdapter;
import com.ramon.matchgame.webservice.flicker.model.Photo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchingActivity extends AppCompatActivity implements MatchingPresenter.View {

    private MatchingPresenter presenter;
    @BindView(R.id.move_counter)
    TextView moveTracker;
    @BindView(R.id.game_board)
    RecyclerView gameBoard;
    private GameBoardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
        ButterKnife.bind(this);
        presenter = new MatchingPresenter(this, getIntent());

    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onViewCreated();
    }

    @Override
    public void incrementMoveCounter(int numOfMoves) {
        moveTracker.setText(getString(R.string.moveTracker, numOfMoves));
    }

    @Override
    public void initializeView(int boardSize, List<Photo> photo, int numOfMoves) {
        moveTracker.setText(getString(R.string.moveTracker, numOfMoves));
        gameBoard.setLayoutManager(new GridLayoutManager(this, boardSize));
        adapter = new GameBoardAdapter(photo, presenter);
        gameBoard.setAdapter(adapter);
    }

    @Override
    public void showGameWon(int numOfMoves) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(getString(R.string.winningMessage,numOfMoves));
                alertDialogBuilder.setPositiveButton(getString(R.string.new_game),
                        (arg0, arg1) -> finish());

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(BundleKeys.RV_KEY,gameBoard.getLayoutManager().onSaveInstanceState());
        outState=presenter.saveState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState!=null){
            gameBoard.getLayoutManager().onRestoreInstanceState(savedInstanceState.getParcelable(BundleKeys.RV_KEY));
            presenter.restoreState(savedInstanceState);
        }
    }
}
