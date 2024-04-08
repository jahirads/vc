package com.ads.sdk.sfdsf1;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface fds1df514 {


    @GET("getRequest.json")
    Call<JsonObject> doCall();

    @GET("getSafe.json")
    Call<JsonObject> doSafe();
}