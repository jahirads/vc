package freecall.videocall.freelivechat.global.livecall;

import static freecall.videocall.freelivechat.global.livecall.dsd14s514.dsa5d145.isVectorShow;

import android.app.Activity;

import com.ads.sdk.fdf4d46.dw4sd5sd4;

public class dfd5f4554dv {

    public static void changeVectorStatus(Activity activity) {
        if (new dw4sd5sd4(activity).getAdmobNativeStatus().equals("1") || new dw4sd5sd4(activity).getFbAdshowStatus().equals("1") || new dw4sd5sd4(activity).getCustomNative().equals("1")) {
            isVectorShow = false;
        } else {
            isVectorShow = true;
        }
    }
}
