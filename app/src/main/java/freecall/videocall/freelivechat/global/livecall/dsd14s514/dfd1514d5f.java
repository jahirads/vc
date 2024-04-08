package freecall.videocall.freelivechat.global.livecall.dsd14s514;

import static freecall.videocall.freelivechat.global.livecall.dsd14s514.dsa5d145.incoming_counter;
import static freecall.videocall.freelivechat.global.livecall.dsd14s514.dsa5d145.isVectorShow;
import static freecall.videocall.freelivechat.global.livecall.s2d1s31d.f151d5vf.native_ShowAds;
import static freecall.videocall.freelivechat.global.livecall.adx12s51cd5.ds21d2s14.connectInComing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.ads.sdk.sf4d;
import com.ads.sdk.fdf4d46.dw4sd5sd4;

import freecall.videocall.freelivechat.global.livecall.R;
import freecall.videocall.freelivechat.global.livecall.szxd4s545.f641df5641;

public class dfd1514d5f extends AppCompatActivity {

    LinearLayout guide_1, guide_2, guide_3, guide_4, guide_5, guide_6, guide_7, guide_8, guide_9, guide_0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.df1ds32f14);

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

        init();

        guide_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dfd1514d5f.this, f641df5641.class));
            }
        });

        guide_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(1);
            }
        });
        guide_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(2);
            }
        });
        guide_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(3);
            }
        });
        guide_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(4);
            }
        });
        guide_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(5);
            }
        });
        guide_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(6);
            }
        });
        guide_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(7);
            }
        });
        guide_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next(8);
            }
        });
    }

    public void init() {
        guide_1 = findViewById(R.id.guide_1);
        guide_2 = findViewById(R.id.guide_2);
        guide_3 = findViewById(R.id.guide_3);
        guide_4 = findViewById(R.id.guide_4);
        guide_5 = findViewById(R.id.guide_5);
        guide_6 = findViewById(R.id.guide_6);
        guide_7 = findViewById(R.id.guide_7);
        guide_8 = findViewById(R.id.guide_8);
        guide_9 = findViewById(R.id.guide_1);
        guide_0 = findViewById(R.id.guide_0);
    }

    public void next(int count) {
        if (new dw4sd5sd4(dfd1514d5f.this).getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
            connectInComing(dfd1514d5f.this);
        } else {
            Intent intent = new Intent(dfd1514d5f.this, fedf3221.class);
            intent.putExtra("counter", count);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        sf4d.ShowInterstitialAdsOnBack(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (!isVectorShow) {
            ((ImageView) findViewById(R.id.vector_pro)).setVisibility(View.GONE);
        }

        if (new dw4sd5sd4(this).getKeyOnresumenativeshow().equals("1")) {
            native_ShowAds(this, findViewById(R.id.native_container), 2);
        }
    }
}