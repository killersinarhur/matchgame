package com.ramon.matchgame.actualgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.ramon.matchgame.R;
import com.ramon.matchgame.actualgame.gameviewholder.GameBoardAdapter;
import com.ramon.matchgame.webservice.flicker.model.Photo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchingActivity extends AppCompatActivity implements MatchingPresenter.View {
    public static final String FLICKER_RESULTS_KEY = "FLICKER_RESULTS_KEY";
    public static final String NUMBER_OF_IMAGES_KEY = "NUMBER_OF_IMAGES_KEY";
    public static final String BOARD_SIZE_KEY = "BOARD_SIZE_KEY";
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


}
