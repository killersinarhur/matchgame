package com.ramon.matchgame.webservice.flicker;

import android.app.Application;
import android.util.Log;

import com.ramon.matchgame.webservice.flicker.callback.PhotoCallBack;
import com.ramon.matchgame.webservice.flicker.callback.PhotoSizeCallback;
import com.ramon.matchgame.webservice.flicker.model.FlikerResults;
import com.ramon.matchgame.webservice.flicker.model.ImageSizeResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlickerClient {
    private static final String RECENT_PHOTO_METHOD = "flickr.photos.search";
    private static final String PHOTO_SIZE_METHOD = "flickr.photos.getSizes";
    private static final String RESPONSE_FORMAT = "json";
    private static final String API_KEY = "5423dbab63f23a62ca4a986e7cbb35e2";

    private final FlickerApi client;
    private final Application app;

    public FlickerClient(Application app, FlickerApi client) {
        this.app = app;
        this.client = client;
    }

    public void getPhotos(PhotoCallBack callBack, int results,String tag,int page) {
        client.getPhotos(RECENT_PHOTO_METHOD, API_KEY, RESPONSE_FORMAT,1, results,tag,1,1,1).enqueue(new Callback<FlikerResults>() {
            @Override
            public void onResponse(Call<FlikerResults> call, Response<FlikerResults> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getStat().equals("ok")) {
                    callBack.onPhotosSuccess(response.body());
                } else {
                    callBack.onPhotosFailure(response.code(), response.message());
                    Log.d(RECENT_PHOTO_METHOD,response.message());
                }
            }

            @Override
            public void onFailure(Call<FlikerResults> call, Throwable t) {
                t.printStackTrace();
                callBack.onPhotosFailure(-1, t.getMessage());
            }
        });
    }

    public void getPhotoSizes(PhotoSizeCallback callback, String photoId) {
        client.getImageSizes(PHOTO_SIZE_METHOD, API_KEY, RESPONSE_FORMAT, 1,photoId).enqueue(new Callback<ImageSizeResult>() {
            @Override
            public void onResponse(Call<ImageSizeResult> call, Response<ImageSizeResult> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getStat().equals("ok")) {
                    callback.onImageSizeSuccess(response.body());
                } else {
                    callback.onImageSizeFailure(response.code(), response.message());
                    Log.d(PHOTO_SIZE_METHOD,response.message());
                }
            }

            @Override
            public void onFailure(Call<ImageSizeResult> call, Throwable t) {
                t.printStackTrace();
                callback.onImageSizeFailure(-1, t.getMessage());
            }
        });
    }
}
