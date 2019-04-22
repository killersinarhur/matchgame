package com.ramon.matchgame;

import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({BundleKeys.BOARD_SIZE_KEY, BundleKeys.FLICKER_RESULTS_KEY, BundleKeys.NUMBER_OF_IMAGES_KEY, BundleKeys.RV_KEY
        ,BundleKeys.START_BOARD_KEY,BundleKeys.START_NUMS_KEY})
public @interface BundleKeys {
    String FLICKER_RESULTS_KEY = "FLICKER_RESULTS_KEY";
    String NUMBER_OF_IMAGES_KEY = "NUMBER_OF_IMAGES_KEY";
    String BOARD_SIZE_KEY = "BOARD_SIZE_KEY";
    String RV_KEY = "RV_KEY";
    String START_NUMS_KEY = "START_NUMS_KEY";
    String START_BOARD_KEY = "START_BOARD_KEY";
    String MATCH_NUM_OF_MOVES = "MATCH_NUM_OF_MOVES";
    String MATCHES_MADE = "MATCHES_MADE";
    String MATCH_BOARD_SIZE ="MATCH_BOARD_SIZE" ;
    String MATCH_NUM_IMAGES ="MATCH_NUM_IMAGES" ;
    String MATCH_FLIK_RESULTS = "MATCH_FLIK_RESULTS";
    String MATCH_PHOTO_ARRAY ="MATCH_PHOTO_ARRAY" ;
}
