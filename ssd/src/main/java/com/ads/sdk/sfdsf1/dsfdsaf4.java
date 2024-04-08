package com.ads.sdk.sfdsf1;

import android.content.Context;
import android.util.Log;

import com.ads.sdk.fdf4d46.ddddd44;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class dsfdsaf4 {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(Context applicationContext, String packageName) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                HostnameVerifier hv = HttpsURLConnection.getDefaultHostnameVerifier();
                return hv.verify(ddddd44.apiHost(applicationContext, packageName), session);
            }
        }).build();


        retrofit = new Retrofit.Builder()
                .baseUrl(ddddd44.baseURL(applicationContext, packageName))
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }


}