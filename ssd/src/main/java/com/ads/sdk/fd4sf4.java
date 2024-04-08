package com.ads.sdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.ads.sdk.fdf444.dfsd4;
import com.ads.sdk.fdf444.sa5sa65s;
import com.ads.sdk.fdf444.sfd4s5f4;
import com.ads.sdk.fdf4d46.dw4sd5sd4;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class fd4sf4 {

    private static fd4sf4 instance;

    public static fd4sf4 getManager() {
        if (instance == null) {
            instance = new fd4sf4();
        }
        return instance;
    }

    public void initialize(Application mContext, Class<?> splashClass) {
        MobileAds.initialize(mContext.getApplicationContext(), new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        AudienceNetworkAds.initialize(mContext);
        new sa5sa65s(mContext, splashClass);
    }

    public static boolean isOnline(Activity activity) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public void preLoadAds(Activity activity) {

        if (!new dw4sd5sd4(activity).getAdmobInterstitialID().isEmpty() ) {

            if (!new dw4sd5sd4(activity).getAdmobInterStatus().equals("0")) {
                sfd4s5f4.getManager(activity).loadAd(activity,true);
            }

            if (!new dw4sd5sd4(activity).getAdmobInterStatus().equals("0")) {
                sfd4s5f4.getManager(activity).loadBackAd(activity);
            }
        }

        if (!new dw4sd5sd4(activity).getAdmobNative().equals("0") &&
                !new dw4sd5sd4(activity).getAdmobNativeID().isEmpty()) {
            dfsd4.getInstance(activity).preLoadNativeAds(activity,0);
        }
    }
}
