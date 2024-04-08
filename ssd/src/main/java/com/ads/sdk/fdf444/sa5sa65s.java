package com.ads.sdk.fdf444;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.ads.sdk.fdf4d46.ddddd44;
import com.ads.sdk.fdf4d46.dw4sd5sd4;


public class sa5sa65s implements Application.ActivityLifecycleCallbacks, DefaultLifecycleObserver {
    private Activity currentActivity;
    private Class<?> splashClass;
    private static final String TAG = "sa5sa65s";

    dsdsdd44 dsdsdd44;

    public sa5sa65s(Application application, Class<?> aClass) {
        splashClass = aClass;
        application.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
        dsdsdd44 = new dsdsdd44();
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onStart(owner);

        if (ddddd44.isNetworkAvailable(currentActivity) && new dw4sd5sd4(currentActivity).getAdsFlag() && !new dw4sd5sd4(currentActivity).getAdmobAppOpenID().isEmpty() &&!currentActivity.getClass().getSimpleName().equals("Activity_ScanQRCode")) {
            dsdsdd44.showAdIfAvailable(currentActivity, splashClass);
        }
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        DefaultLifecycleObserver.super.onDestroy(owner);
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {

    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        currentActivity = activity;
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {

    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {

    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {

    }

}
