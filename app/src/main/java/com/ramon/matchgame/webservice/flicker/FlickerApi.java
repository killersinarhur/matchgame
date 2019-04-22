package com.ramon.matchgame.webservice.flicker;

import com.ramon.matchgame.webservice.flicker.model.FlikerResults;
import com.ramon.matchgame.webservice.flicker.model.ImageSizeResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FlickerApi {
    @GET("services/rest/")
    Call<FlikerResults> getPhotos(@Query("method") String method,
                                  @Query("api_key") String apiKey,
                                  @Query("format") String format,
                                  @Query("nojsoncallback") int value,
                                  @Query("per_page") int perPage,
                                  @Query("tags") String tag,
                                  @Query("privacy_filter") int filter,
                                  @Query("safe_search") int safeSearch,
                                  @Query("content_type")int contentType);

    @GET("services/rest/")
    Call<ImageSizeResult> getImageSizes(@Query("method") String method,
                                        @Query("api_key") String apiKey,
                                        @Query("format") String format,
                                        @Query("nojsoncallback") int value,
                                        @Query("photo_id") String photoId);
}
