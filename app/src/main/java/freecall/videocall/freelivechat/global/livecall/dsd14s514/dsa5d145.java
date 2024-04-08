package freecall.videocall.freelivechat.global.livecall.dsd14s514;

import static freecall.videocall.freelivechat.global.livecall.s2d1s31d.f151d5vf.native_ShowAds;
import static freecall.videocall.freelivechat.global.livecall.adx12s51cd5.ds21d2s14.connectInComing;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.ads.sdk.sf4d;
import com.ads.sdk.fdf4d46.dw4sd5sd4;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.DexterError;
import com.karumi.dexter.listener.PermissionRequestErrorListener;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import freecall.videocall.freelivechat.global.livecall.R;
import freecall.videocall.freelivechat.global.livecall.dfd5f4554dv;
import freecall.videocall.freelivechat.global.livecall.szxd4s545.f641df5641;
import freecall.videocall.freelivechat.global.livecall.adx12s51cd5.sdfs21d21;

import java.util.List;


public class dsa5d145 extends AppCompatActivity {

    public static boolean isVectorShow = true;
    private AppCompatButton welcome;

    //incoming call
    public static int incoming_counter = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fd425f1);
        
        dfd5f4554dv.changeVectorStatus(this);

        if (new sdfs21d21().isTerms() && new dw4sd5sd4(dsa5d145.this).getKeyTermscreen().equals("1")) {
            new sdfs21d21().stopTerms();
            sf4d.ShowInterstitialAdsOnCreate(this);
        }


        if (new dw4sd5sd4(this).getKeyOnresumenativeshow().equals("0")) {
            native_ShowAds(this, findViewById(R.id.native_container), 1);
        }


        welcome = findViewById(R.id.welcome);


        welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestPR();
            }
        });

    }

    private void goNextScreen() {
        if (new dw4sd5sd4(dsa5d145.this).getIncoming_Welcome().equalsIgnoreCase("1") && incoming_counter == -1) {
            connectInComing(dsa5d145.this);
        } else {
            if (new dw4sd5sd4(dsa5d145.this).getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
                connectInComing(dsa5d145.this);
            } else {
                if (new dw4sd5sd4(dsa5d145.this).getIsLongApp().equalsIgnoreCase("1")) {
                    startActivity(new Intent(dsa5d145.this, s4d185d4fv5.class));
                } else {
                    startActivity(new Intent(dsa5d145.this, f641df5641.class));
                }
            }
        }
    }


    @Override
    public void onBackPressed() {
        if (new dw4sd5sd4(this).getKeyExitscreen().equals("1")) {
            startActivity(new Intent(dsa5d145.this, df125f1d5vf.class).putExtra("issplash", 1));
        } else {
            tagAgainToExit();
        }
    }


    boolean doubleBackToExitPressedOnce = false;

    private void tagAgainToExit() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);
    }


    private void requestPR() {

        Dexter.withActivity(dsa5d145.this).withPermissions(Manifest.permission.CAMERA).withListener(new MultiplePermissionsListener() {
            @Override
            public void onPermissionsChecked(MultiplePermissionsReport report) {
                if (report.areAllPermissionsGranted()) {
                    goNextScreen();
                } else if (report.isAnyPermissionPermanentlyDenied()) {
                    showSettingsDialog();
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(List permissions, PermissionToken token) {
                token.continuePermissionRequest();
            }
        }).withErrorListener(new PermissionRequestErrorListener() {
            @Override
            public void onError(DexterError error) {
                Toast.makeText(getApplicationContext(), "Error" + error.toString(), Toast.LENGTH_SHORT).show();
            }
        }).onSameThread().check();

    }

    private void showSettingsDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(dsa5d145.this, R.style.Theme_Dllg);
        builder.setTitle("Need Permissions");
        builder.setMessage("This App needs CAMERA Permission to Use Video Call Feature. You can Grant them in App f1df1.");
        builder.setPositiveButton("GOTO SETTINGS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                openSettings();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    private void openSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", getPackageName(), null);
        intent.setData(uri);
        startActivityForResult(intent, 101);
    }
}