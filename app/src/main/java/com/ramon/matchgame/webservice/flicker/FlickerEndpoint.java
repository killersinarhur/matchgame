package com.ramon.matchgame.webservice.flicker;

import android.webkit.URLUtil;

public class FlickerEndpoint {
    public String getEndpoint() {
        return "https://api.flickr.com/";
    }

    public static String buildImageUrl(Integer farmId, String serverId, String photoId, String photoSecretId, String photoSize, String imageFormat ){
        String url="https://farm" +
                farmId +
                ".staticflickr.com/" +
                serverId +
                "/" +
                photoId +
                "_" +
                photoSecretId +
                "_" +
                photoSize + "." + imageFormat;



       return URLUtil.isValidUrl(url)?url:null;
    }
}
