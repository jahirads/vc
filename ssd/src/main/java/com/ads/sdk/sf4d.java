package com.ads.sdk;

import static com.ads.sdk.fdf4d46.dw4sd5sd4.app_back_count_click;
import static com.ads.sdk.fdf4d46.dw4sd5sd4.app_combo_counter;
import static com.ads.sdk.fdf4d46.dw4sd5sd4.app_count_click;
import static com.ads.sdk.fdf4d46.dw4sd5sd4.isComboActive;

import android.app.Activity;

import com.ads.sdk.fdf444.sfd4s5f4;
import com.ads.sdk.fdf4d46.dw4sd5sd4;
import com.ads.sdk.ffff444.fdf44f;

public class sf4d {

    public static void ShowInterstitialAdsOnCreate(Activity activity) {

        if (isComboActive) {
            if (app_combo_counter == Integer.parseInt(new dw4sd5sd4(activity).getComboCount())) {
                callingInter(activity);
                app_combo_counter = 0;
            } else {
                app_combo_counter = app_combo_counter + 1;
            }
        } else {
            callingInter(activity);
        }


    }

    private static void callingInter(Activity activity) {
        sfd4s5f4.getManager(activity).showInterAd(activity, new fdf44f() {
            @Override
            public void onShowAdComplete() {
                sfd4s5f4.getManager(activity).showFacebookAds(activity);
            }
        }, app_count_click);
    }



    public static void ShowInterstitialAdsOnBack(Activity activity) {
        sfd4s5f4.getManager(activity).ShowInterBackAd(activity, new fdf44f() {
            @Override
            public void onShowAdComplete() {
                activity.finish();
            }
        }, app_back_count_click);
    }
}