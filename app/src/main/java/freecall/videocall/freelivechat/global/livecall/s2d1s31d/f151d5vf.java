package freecall.videocall.freelivechat.global.livecall.s2d1s31d;

import static com.ads.sdk.fdf4d46.dw4sd5sd4.app_count_click;

import android.app.Activity;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.ads.sdk.fd4sf4;
import com.ads.sdk.fdf444.dfsd4;
import freecall.videocall.freelivechat.global.livecall.R;
import freecall.videocall.freelivechat.global.livecall.adx12s51cd5.sdfs21d21;

import java.util.Date;

public class f151d5vf extends Application {
    private static final String FIRST_LAUNCH = "FIRST_LAUNCH";
    private static Context context = null;
    private static f151d5vf instance_app_data = null;

    public static final String CHANEL_ID = "Video Call";


    private f151d5vf mInstance;

    private void createNotificationChangel() {
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel(CHANEL_ID, getResources().getString(R.string.app_name), NotificationManager.IMPORTANCE_DEFAULT));
        }
    }

    public static boolean isNetworkConnected(Activity activity) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) activity.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }

    public static void native_ShowAds(Activity activity, ViewGroup viewGroup, int Type) {
        if (Type == 1) {
            dfsd4.getInstance(activity).show_native_AD(activity, viewGroup, 1, app_count_click);
        } else {
            dfsd4.getInstance(activity).show_native_AD(activity, viewGroup, 2, app_count_click);
        }
    }


    public static Context getContext() {
        return context;
    }

    public static f151d5vf getInstance() {
        return instance_app_data;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        setFirstLaunch(this);
        context = getApplicationContext();
        instance_app_data = this;

        if (Build.VERSION.SDK_INT >= 24) {
            try {
                StrictMode.class.getMethod("disableDeathOnFileUriExposure", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mInstance = this;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            if (!getPackageName().equals(Application.getProcessName())) {
                WebView.setDataDirectorySuffix(Application.getProcessName());
            }
        }

        createNotificationChangel();
        fd4sf4.getManager().initialize(this, f1sd5f145.class);

        //onetime
        sdfs21d21.initializingSharedPreference(context);
    }


    private static void setFirstLaunch(Context context2) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context2.getApplicationContext());
        if (!defaultSharedPreferences.contains(FIRST_LAUNCH)) {
            defaultSharedPreferences.edit().putLong(FIRST_LAUNCH, new Date().getTime()).apply();
        }
    }


}