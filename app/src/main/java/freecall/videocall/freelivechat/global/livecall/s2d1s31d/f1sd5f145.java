package freecall.videocall.freelivechat.global.livecall.s2d1s31d;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.ads.sdk.fdf4d46.dw4sd5sd4;
import com.ads.sdk.ds4d5;
import freecall.videocall.freelivechat.global.livecall.BuildConfig;
import freecall.videocall.freelivechat.global.livecall.R;
import freecall.videocall.freelivechat.global.livecall.cd654fcZ;
import freecall.videocall.freelivechat.global.livecall.adx12s51cd5.sdfs21d21;
import freecall.videocall.freelivechat.global.livecall.dsd14s514.dsa5d145;


public class f1sd5f145 extends ds4d5 {

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.sssss);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
                return;
            } else {
                loadSplash(BuildConfig.DEBUG, BuildConfig.VERSION_CODE);
            }
        } else {
            loadSplash(BuildConfig.DEBUG, BuildConfig.VERSION_CODE);
        }
    }


    @Override
    public void onComplete() {

        manageVip();

        if (new dw4sd5sd4(this).getKeyTermscreen().equals("1")) {
            if (new sdfs21d21().isTerms()) {
                startActivity(new Intent(f1sd5f145.this, cd654fcZ.class).putExtra("issplash", 1));
            } else {
                startActivity(new Intent(f1sd5f145.this, dsa5d145.class).putExtra("issplash", 1));
            }
        } else {
            startActivity(new Intent(f1sd5f145.this, dsa5d145.class).putExtra("issplash", 1));
        }
        finish();

    }

    private void manageVip() {

        if (new sdfs21d21().getVipType().equals("in_app_gold")) {
            new dw4sd5sd4(this).redeemGoldPlan();
//            new dw4sd5sd4(this).setAdsFlag(false);
//            new dw4sd5sd4(this).set_IncomingWelcome_Fix();
        } else if (new sdfs21d21().getVipType().equals("in_app_silver")) {
            new dw4sd5sd4(this).redeemSilverPlan();
        } else if (new sdfs21d21().getVipType().equals("in_app_bronze")) {
            new dw4sd5sd4(this).redeemBronzePlan();
            SharedPreferences sh = getSharedPreferences("RandomSF", MODE_APPEND);
            int vc_count = sh.getInt("KEY_RAND", 0);
            if (vc_count == 7) {
                new sdfs21d21().setVipType("null");
                Toast.makeText(this, "Bronze Premium Expire! You reached your call limit.", Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            switch (requestCode) {
                case 101: {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        loadSplash(BuildConfig.DEBUG, BuildConfig.VERSION_CODE);
                    } else {
                        loadSplash(BuildConfig.DEBUG, BuildConfig.VERSION_CODE);
                    }
                    return;
                }
            }
        }
    }


}
