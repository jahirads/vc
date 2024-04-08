package freecall.videocall.freelivechat.global.livecall.dsd14s514;

import static freecall.videocall.freelivechat.global.livecall.dsd14s514.dsa5d145.incoming_counter;
import static freecall.videocall.freelivechat.global.livecall.s2d1s31d.f151d5vf.native_ShowAds;
import static freecall.videocall.freelivechat.global.livecall.adx12s51cd5.ds21d2s14.connectInComing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ads.sdk.sf4d;
import com.ads.sdk.fdf4d46.dw4sd5sd4;

import freecall.videocall.freelivechat.global.livecall.R;

public class dsfvg1d45v1 extends AppCompatActivity {

    LinearLayout videocall, videocall_advice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.df4d1214);

        findViewById(R.id.img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        incoming_counter++;

        dw4sd5sd4.show_anim_header(this, (RelativeLayout) findViewById(R.id.rl_anim_header));
        sf4d.ShowInterstitialAdsOnCreate(this);
        if (new dw4sd5sd4(this).getKeyOnresumenativeshow().equals("0")) {
            native_ShowAds(this, findViewById(R.id.native_container), 2);
        }


        videocall = findViewById(R.id.videocall);
        videocall_advice = findViewById(R.id.videocall_advice);

        videocall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new dw4sd5sd4(dsfvg1d45v1.this).getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
                    connectInComing(dsfvg1d45v1.this);
                } else {
                    startActivity(new Intent(dsfvg1d45v1.this, fsdf5f454.class));
                }
            }
        });


        videocall_advice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new dw4sd5sd4(dsfvg1d45v1.this).getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
                    connectInComing(dsfvg1d45v1.this);
                } else {
                    startActivity(new Intent(dsfvg1d45v1.this, dfd1514d5f.class));
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        sf4d.ShowInterstitialAdsOnBack(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (new dw4sd5sd4(this).getKeyOnresumenativeshow().equals("1")) {
            native_ShowAds(this, findViewById(R.id.native_container), 2);
        }
    }
}