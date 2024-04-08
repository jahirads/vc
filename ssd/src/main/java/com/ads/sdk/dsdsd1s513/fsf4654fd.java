package com.ads.sdk.dsdsd1s513;

import static com.ads.sdk.fdf4d46.ddddd44.getPlayStoreUrl;
import static com.ads.sdk.fdf4d46.ddddd44.openChromeCustomTabUrl;
import static com.ads.sdk.ds4d5.customAdData;
import static com.ads.sdk.ds4d5.getMyCustomAd;
import static com.ads.sdk.ds4d5.getRandomNum;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.ads.sdk.R;
import com.ads.sdk.fdf4d46.dw4sd5sd4;
import com.ads.sdk.ffff444.fdf44f;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class fsf4654fd extends AppCompatActivity {

    public static fdf44f listner;
    gfd1g21 customAdModel;
    private String action_str;
    private ImageView CloseBtn;
    private ImageView iv_inter;
    private boolean clicked = false;

    public static void newIntent(Activity activity, fdf44f listner_for_app) {
        if (new dw4sd5sd4(activity).getCustomAdshowStatus().equals("0") || new dw4sd5sd4(activity).getCustomInter().equals("0")) {
            return;
        }
        listner = listner_for_app;
        activity.startActivity(new Intent(activity, fsf4654fd.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.g3r);
        if (new dw4sd5sd4(this).getCustomAdshowStatus().equals("0") || new dw4sd5sd4(this).getCustomInter().equals("0")) {
            return;
        }
        customAdModel = getMyCustomAd();
        int pos = getRandomNum();
        if (customAdModel != null) {
            try {
                iv_inter = (ImageView) findViewById(R.id.iv_inter);
                CloseBtn = (ImageView) findViewById(R.id.iv_close);
                Glide.with(this).load(customAdData.get(pos).getInterstitialImage()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.img_interstitial).into(iv_inter);
                findViewById(R.id.iv_inter).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        clicked = true;
                        action_str = customAdData.get(pos).getUrl();
                        if (action_str.startsWith("https")) {
                            startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getPlayStoreUrl(action_str))));
                        } else {
                            openChromeCustomTabUrl(fsf4654fd.this, action_str);
                        }
                    }
                });
                CloseBtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        closeAd(fsf4654fd.this, pos);
                    }
                });
            } catch (Exception e) {
                closeAd(fsf4654fd.this, pos);
            }
        } else {
            finish();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (clicked) {
            clicked = false;
            if (listner != null) {
                listner.onShowAdComplete();
                listner = null;
            }
            finish();
        }
    }

    private void closeAd(Activity activity, int pos) {
        if (new dw4sd5sd4(activity).getCustomCloseAd().equals("1")) {
            clicked = true;
            action_str = customAdData.get(pos).getUrl();
            if (action_str.startsWith("https")) {
                startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getPlayStoreUrl(action_str))));
            } else {
                openChromeCustomTabUrl(fsf4654fd.this, action_str);
            }
        } else {
            if (listner != null) {
                listner.onShowAdComplete();
                listner = null;
            }
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        if (listner != null) {
            listner.onShowAdComplete();
            listner = null;
        }
        finish();
    }
}