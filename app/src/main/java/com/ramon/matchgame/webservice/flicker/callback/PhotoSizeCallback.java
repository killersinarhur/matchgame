package com.ramon.matchgame.webservice.flicker.callback;

import com.ramon.matchgame.webservice.flicker.model.ImageSizeResult;

public interface PhotoSizeCallback {
    void onImageSizeSuccess(ImageSizeResult imageSizeResult);

    void onImageSizeFailure(int code, String message);
}
