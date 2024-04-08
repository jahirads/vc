package com.ads.sdk;

import static com.ads.sdk.dsf4d5.ipipipi.Fsdaf1s3d24.getGeoApiService;
import static com.ads.sdk.fdf4d46.dw4sd5sd4.Glob_Notification_Minutes;
import static com.ads.sdk.fdf4d46.dw4sd5sd4.app_back_count_click;
import static com.ads.sdk.fdf4d46.dw4sd5sd4.app_count_click;
import static com.ads.sdk.fdf4d46.dw4sd5sd4.dsf4dsf45List;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.ads.sdk.dsdsd1s513.gfd1g21;
import com.ads.sdk.dsf4d5.fedf4df5.asdsd4125;
import com.ads.sdk.dsf4d5.fedf4df5.xf1sdf5d;
import com.ads.sdk.dsf4d5.ipipipi.f1ds2f1;
import com.ads.sdk.dsf4d5.ipipipi.fd15641;
import com.ads.sdk.dsf4d5.xfsd4f5.f1df1;
import com.ads.sdk.dsf4d5.xfsd4f5.fsd1f2d1f;
import com.ads.sdk.dsf4d5.xfsd4f5.zd1as5s1f;
import com.ads.sdk.fdf444.dsdsdd44;
import com.ads.sdk.fdf4d46.dw4sd5sd4;
import com.ads.sdk.sfdsf1.dsfdsaf4;
import com.ads.sdk.sfdsf1.fds1df514;
import com.ads.sdk.fdf4d46.ddddd44;
import com.ads.sdk.ffff444.fdf44f;
import com.ads.sdk.cgvfd5g4v1.safasf45;
import com.ads.sdk.cgvfd5g4v1.dsfdf563;
import com.ads.sdk.cgvfd5g4v1.sfdsdf555;
import com.ads.sdk.cgvfd5g4v1.model.f4d5f;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class ds4d5 extends AppCompatActivity {
    private static final String TAG = ds4d5.class.getSimpleName();

    private static final int REQUEST_CODE_POST_NOTIFICATION = 30;
    private static int totalAdInc;
    private static Random r;
    private JsonArray jsonArray;


    //verify
    String iType = "";
    public boolean excludeChecker = false;
    public boolean includeChecker = false;
    private int globalVerionCode = 1;


    public abstract void onComplete();

    public void loadSplash(Boolean debug, int versionCode) {
        ddddd44.DEBUG = debug;
        globalVerionCode = versionCode;
        if (!ddddd44.isNetworkAvailable(ds4d5.this)) {

            new AlertDialog.Builder(ds4d5.this)
                    .setTitle("No Internet")
                    .setCancelable(false)
                    .setMessage("Please check your internet connection and try again.")
                    .setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            loadSplash(debug, versionCode);
                        }
                    }).setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int i) {
                            dialog.dismiss();
                            finishAffinity();
                        }
                    }).setIcon(android.R.drawable.ic_dialog_alert).show();
        } else {

            //check Safety..
            xf1sdf5d sInterface = asdsd4125.getClient(getApplicationContext(), getApplicationContext().getPackageName()).create(xf1sdf5d.class);
            Call<f1df1> callSetting = sInterface.doCall();
            callSetting.enqueue(new Callback<f1df1>() {
                @Override
                public void onResponse(Call<f1df1> call, Response<f1df1> response) {
                    fsd1f2d1f app_settings = response.body().getSettings();

                    iType = app_settings.getLocType();
                    verifyUser(app_settings.getLocArray());
                }

                @Override
                public void onFailure(Call<f1df1> call, Throwable t) {
                    safeCalling();
                }
            });


        }
    }

    private void verifyUser(List<zd1as5s1f> iArray) {
        fd15641 apiService = getGeoApiService(getApplicationContext(), getApplicationContext().getPackageName());
        apiService.getLocation().enqueue(new retrofit2.Callback<f1ds2f1>() {
            @Override
            public void onResponse(Call<f1ds2f1> call, Response<f1ds2f1> response) {
                String uCountryCode = response.body().getCountryCode();
                String uStateCode = response.body().getRegion();
                String uCityName = response.body().getCity();


                switch (iType) {
                    case "include":
                        for (int k = 0; k < iArray.size(); k++) {
                            if (uCountryCode.equalsIgnoreCase(iArray.get(k).getCountryCode()) ||
                                    uStateCode.equalsIgnoreCase(iArray.get(k).getStateCode()) ||
                                    uCityName.equalsIgnoreCase(iArray.get(k).getCityName())) {
                                k = 999;
                                includeChecker = true;
                            }
                        }

                        if (includeChecker) {
                            safeCalling();
                        } else {
                            calling();
                        }
                        break;

                    case "exclude":
                        for (int j = 0; j < iArray.size(); j++) {
                            if (uCountryCode.equalsIgnoreCase(iArray.get(j).getCountryCode()) ||
                                    uStateCode.equalsIgnoreCase(iArray.get(j).getStateCode()) ||
                                    uCityName.equalsIgnoreCase(iArray.get(j).getCityName())) {
                                j = 999;
                                excludeChecker = true;
                            }
                        }

                        if (excludeChecker) {
                            safeCalling();
                        } else {
                            calling();
                        }
                        break;

                    default:
                        safeCalling();
                        break;
                }
            }

            @Override
            public void onFailure(Call<f1ds2f1> call, Throwable t) {
                safeCalling();
            }
        });
    }

    private void calling() {
        //call Normal..
        fds1df514 fds1df514 = dsfdsaf4.getClient(getApplicationContext(), getApplicationContext().getPackageName()).create(fds1df514.class);
        Call<JsonObject> call = fds1df514.doCall();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                new dw4sd5sd4(ds4d5.this).setInstallType();
                if (response.body() != null && response.body().get("status").getAsBoolean()) {
                    JsonObject app_seeting = response.body().get("data").getAsJsonObject();
                    new dw4sd5sd4(ds4d5.this).setAdsResponse(app_seeting);
                    jsonArray = app_seeting.getAsJsonArray("G3Q_Video_Call_by_Sneh_Developer_customAdData");
                    getSplashMoreAppData(jsonArray, ds4d5.this);
                }

                if (new dw4sd5sd4(ds4d5.this).getAppUpdateFlag() && new dw4sd5sd4(ds4d5.this).getUpdateVersionCode() > globalVerionCode) {
                    new AlertDialog.Builder(ds4d5.this)
                            .setTitle("New Version Available")
                            .setCancelable(false)
                            .setMessage("It looks like you have an old version of the app, Please update the app and enjoy our latest features.")
                            .setPositiveButton("Update now", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    ddddd44.rateUs(ds4d5.this);
                                    finishAffinity();
                                }
                            }).setNegativeButton("Later", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    checkVpnEnable();
                                }
                            }).show();
                } else {
                    checkVpnEnable();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
//                    Log.e("@@TAG", "onFailure: " + t.getMessage());
                new dw4sd5sd4(ds4d5.this).setInstallType();
                checkVpnEnable();
            }
        });
    }

    private void safeCalling() {
        //call Normal..
        fds1df514 fds1df514 = dsfdsaf4.getClient(getApplicationContext(), getApplicationContext().getPackageName()).create(fds1df514.class);
        Call<JsonObject> call = fds1df514.doSafe();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                new dw4sd5sd4(ds4d5.this).setInstallType();
                if (response.body() != null && response.body().get("status").getAsBoolean()) {
                    JsonObject app_seeting = response.body().get("data").getAsJsonObject();
                    new dw4sd5sd4(ds4d5.this).setAdsResponse(app_seeting);
                    jsonArray = app_seeting.getAsJsonArray("G3Q_Video_Call_by_Sneh_Developer_customAdData");
                    getSplashMoreAppData(jsonArray, ds4d5.this);
                }

                if (new dw4sd5sd4(ds4d5.this).getAppUpdateFlag() && new dw4sd5sd4(ds4d5.this).getUpdateVersionCode() > globalVerionCode) {
                    new AlertDialog.Builder(ds4d5.this)
                            .setTitle("New Version Available")
                            .setCancelable(false)
                            .setMessage("It looks like you have an old version of the app, Please update the app and enjoy our latest features.")
                            .setPositiveButton("Update now", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    ddddd44.rateUs(ds4d5.this);
                                    finishAffinity();
                                }
                            }).setNegativeButton("Later", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                    checkVpnEnable();
                                }
                            }).show();
                } else {
                    checkVpnEnable();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
//                    Log.e("@@TAG", "onFailure: " + t.getMessage());
                new dw4sd5sd4(ds4d5.this).setInstallType();
                checkVpnEnable();
            }
        });
    }

    public static ArrayList<gfd1g21> customAdData = new ArrayList<>();

    public void getSplashMoreAppData(JsonArray response, Activity activity) {
        if (customAdData != null) {
            customAdData.clear();
        }
        if (response != null) {
            for (int i = 0; i < response.size(); i++) {
                JsonObject object = (JsonObject) response.get(i);
                customAdData.add(new gfd1g21(object.get("G3Q_Video_Call_by_Sneh_Developer_cust_id").getAsString(), object.get("G3Q_Video_Call_by_Sneh_Developer_cust_name").getAsString(), object.get("G3Q_Video_Call_by_Sneh_Developer_cust_url").getAsString(), object.get("G3Q_Video_Call_by_Sneh_Developer_cust_appopen_image").getAsString(), object.get("G3Q_Video_Call_by_Sneh_Developer_cust_interstitial_image").getAsString(), object.get("G3Q_Video_Call_by_Sneh_Developer_cust_small_native_image").getAsString(), object.get("G3Q_Video_Call_by_Sneh_Developer_cust_native_image").getAsString()));
            }
            //notification
            if (new dw4sd5sd4(ds4d5.this).getKeyNotification_Status().equals("1")) {
//                Log.e("@@notify", "notification mode >>> ACTIVE");

                //get notification data
                safasf45 safasf45 = sfdsdf555.getRetrofitInstance(getApplicationContext()).create(safasf45.class);
                Call<f4d5f> call = safasf45.getNotifyData();
                call.enqueue(new Callback<f4d5f>() {
                    @Override
                    public void onResponse(Call<f4d5f> call, Response<f4d5f> response) {
                        if (response.isSuccessful()) {
                            f4d5f notification = response.body();
//                            Log.e("@@notify", "time: " + notification.getNotificationTime());
                            Glob_Notification_Minutes = notification.getNotificationTime();
                            if (notification.getNotificationData().size() > 0) {
                                dsf4dsf45List = notification.getNotificationData();
//                                Log.e("@@notify", "data added successful!");


                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (!dsfdf563.IS_ACTIVITY_RUNNING) {
                                            try {
                                                startService();
                                            } catch (Exception e) {
//                                                Log.e("@@notify", "error1: " + e.getMessage());
                                            }
                                        }


                                    }
                                }, 1000);

                            } else {
//                                Log.e("@@notify", "error: data 0");
                            }
                        } else {
//                            Log.e("@@notify", "onFailure: " + "response failed!");
                        }
                    }

                    @Override
                    public void onFailure(Call<f4d5f> call, Throwable t) {
//                        Log.e("@@notify", "onFailure: " + t.getMessage());
                    }
                });

            } else {
//                Log.e("@@notify", "notification mode >>> DISABLE");
            }
        }
    }

    public void startService() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            Intent pushIntent = new Intent(this, dsfdf563.class);
            startForegroundService(pushIntent);
        } else {
            Intent pushIntent = new Intent(this, dsfdf563.class);
            startService(pushIntent);
        }

    }

    public static gfd1g21 getMyCustomAd() {
        gfd1g21 customAdModel = null;
        if (totalAdInc == customAdData.size()) {
            totalAdInc = 0;
        }
        customAdModel = customAdData.get(totalAdInc);
        totalAdInc++;
        return customAdModel;
    }

    public static int getRandomNum() {
        int size = customAdData.size();
        int min = 0;
        int max = size - 1;
        r = new Random();
        int output = r.nextInt((max - min) + 1) + min;
        return output;
    }

    private void checkVpnEnable() {
        loadAd();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE_POST_NOTIFICATION) {
            loadAd();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_POST_NOTIFICATION) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED) {
                loadAd();
            } else {
                new AlertDialog.Builder(ds4d5.this)
                        .setTitle("Permission settings")
                        .setCancelable(false)
                        .setMessage("Notification permission is not enabled. Do you want to go to settings menu?")
                        .setPositiveButton("f1df1", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
                                try {
                                    startActivityForResult(intent, REQUEST_CODE_POST_NOTIFICATION);
                                } catch (ActivityNotFoundException e) {
                                    e.printStackTrace();
                                    loadAd();
                                }
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                loadAd();
                            }
                        }).show();
            }
        }
    }

    private void loadAd() {
        if (ddddd44.isNetworkAvailable(ds4d5.this) && new dw4sd5sd4(ds4d5.this).getAdsFlag()) {
            if (new dw4sd5sd4(ds4d5.this).getAdmobInterStatus().equals("1")) {
                if (new dw4sd5sd4(ds4d5.this).getCountClick() != 0) {
                    app_count_click = app_count_click + 1;
                }
            } else if (new dw4sd5sd4(ds4d5.this).getCustomAdshowStatus().equals("1")) {
                if (new dw4sd5sd4(ds4d5.this).getCountClick() != 0) {
                    app_count_click = app_count_click + 1;
                }
            }

            if (new dw4sd5sd4(ds4d5.this).getAdmobInterStatus().equals("1")) {
                if (new dw4sd5sd4(ds4d5.this).getCountClickBack() != 0) {
                    app_back_count_click = app_back_count_click + 1;
                }
            } else if (new dw4sd5sd4(ds4d5.this).getCustomAdshowStatus().equals("1")) {
                if (new dw4sd5sd4(ds4d5.this).getCountClickBack() != 0) {
                    app_back_count_click = app_back_count_click + 1;
                }
            }
            fd4sf4.getManager().preLoadAds(ds4d5.this);
            if (!new dw4sd5sd4(ds4d5.this).getAdmobAppOpenID().isEmpty() && new dw4sd5sd4(ds4d5.this).getAdmobAppopenStatusStatus().equals("1")) {
                new dsdsdd44().loadSplashAd(ds4d5.this, new fdf44f() {
                    @Override
                    public void onShowAdComplete() {
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                onComplete();
                            }
                        }, 50);
                    }
                });
            } else {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        onComplete();
                    }
                }, 50);
            }
        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    onComplete();
                }
            }, 50);
        }
    }

    @Override
    public void onBackPressed() {
    }
}
