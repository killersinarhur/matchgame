package com.ramon.matchgame.webservice.flicker;

import com.ramon.matchgame.webservice.flicker.model.FlikerResults;
import com.ramon.matchgame.webservice.flicker.model.ImageSizeResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickerApi {
    @GET("services/rest/")
    Call<FlikerResults> getRecentPhotos(@Query("method")String method,
                                        @Query("api_key")String apiKey,
                                        @Query("format")String format,
                                        @Query("tag")String tag);

    @GET("services/rest/")
    Call<ImageSizeResult> getImageSizes(@Query("method")String method,
                                        @Query("api_key")String apiKey,
                                        @Query("format")String format,
                                        @Query("photo_id")String photoId);
}
