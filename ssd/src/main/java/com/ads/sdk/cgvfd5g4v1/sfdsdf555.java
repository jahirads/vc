package com.ads.sdk.cgvfd5g4v1;

import android.content.Context;
import android.util.Log;

import com.ads.sdk.fdf4d46.dw4sd5sd4;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class sfdsdf555 {
    private static Retrofit retrofit;

    public static Retrofit getRetrofitInstance(Context context) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(new dw4sd5sd4(context).getKeyNotification_Link())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}