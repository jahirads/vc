package com.ads.sdk.dsf4d5.ipipipi;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Fsdaf1s3d24 {

//    public static final String BASE_URL = "http://ip-api.com/";

    public static fd15641 getGeoApiService(Context context, String pk) {
        return new Retrofit.Builder()
                .baseUrl(dsaf456f41.baseURL(context, pk))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(fd15641.class);
    }

}
