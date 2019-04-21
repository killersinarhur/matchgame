package com.ramon.matchgame.webservice.flicker.callback;

import com.ramon.matchgame.webservice.flicker.model.FlikerResults;

public interface PhotoCallBack {
    void onPhotosSuccess(FlikerResults flikerResults);
    void onPhotosFailure(int code, String message);
}
