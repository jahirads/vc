package com.ads.sdk.fdf4d46;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

public class notisd4s5d4s {

    private static final int NOTIFICATION_ID = 1;
    private static notisd4s5d4s manager;

    Context mActivity;

    public static notisd4s5d4s getInstance(Context activity) {
        if (manager == null) {
            manager = new notisd4s5d4s(activity);
        }
        return manager;
    }

    public notisd4s5d4s(Context activity) {
        this.mActivity = activity;
    }

    public void clearNotification(){
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(mActivity);
        notificationManager.cancel(NOTIFICATION_ID);
    }

    private Boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(mActivity, Manifest.permission.POST_NOTIFICATIONS) ==
                    PackageManager.PERMISSION_GRANTED) {
                return true;
            }
            ActivityCompat.requestPermissions((Activity) mActivity, new String[]{Manifest.permission.POST_NOTIFICATIONS}, 30);
            return false;
        }
        return true;
    }
}
