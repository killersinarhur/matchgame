package com.ramon.matchgame.actualgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ramon.matchgame.R;
import com.ramon.matchgame.webservice.flicker.model.FlikerResults;

import org.apache.commons.lang3.StringUtils;

public class MatchingActivity extends AppCompatActivity {
    public static final String FLICKER_RESULTS_KEY="FLICKER_RESULTS_KEY";
    public static final String NUMBER_OF_IMAGES_KEY="NUMBER_OF_IMAGES_KEY";
    public static final String BOARD_SIZE_KEY ="BOARD_SIZE_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching);
        retreiveFromIntent(getIntent());

    }

    private void retreiveFromIntent(Intent intent) {
      flickerResults=  getFlickerData(intent.getStringExtra(FLICKER_RESULTS_KEY));
       numofImages= intent.getIntExtra(NUMBER_OF_IMAGES_KEY,8);
       boardSize= intent.getIntExtra(BOARD_SIZE_KEY,4);

    }

    private FlikerResults getFlickerData(String stringExtra) {
       FlikerResults flikerResults= new FlikerResults();
        if(!StringUtils.isEmpty(stringExtra)){
            flikerResults=
        }
    }
}
