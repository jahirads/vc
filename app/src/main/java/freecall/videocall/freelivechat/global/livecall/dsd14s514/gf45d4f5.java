package freecall.videocall.freelivechat.global.livecall.dsd14s514;

import static freecall.videocall.freelivechat.global.livecall.dsd14s514.dsa5d145.incoming_counter;
import static freecall.videocall.freelivechat.global.livecall.dsd14s514.dsa5d145.isVectorShow;
import static freecall.videocall.freelivechat.global.livecall.s2d1s31d.f151d5vf.native_ShowAds;
import static freecall.videocall.freelivechat.global.livecall.adx12s51cd5.ds21d2s14.connectInComing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.ads.sdk.sf4d;
import com.ads.sdk.fdf4d46.dw4sd5sd4;

import freecall.videocall.freelivechat.global.livecall.R;

public class gf45d4f5 extends AppCompatActivity {

    private AppCompatButton age_next;
    private RadioButton r1, r2, r3;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.df54ds4f41);

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
            native_ShowAds(this, findViewById(R.id.native_container), 1);
        }


        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        radioGroup = findViewById(R.id.radioGroup);
        age_next = findViewById(R.id.age_next);

        age_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new dw4sd5sd4(gf45d4f5.this).getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
                    connectInComing(gf45d4f5.this);
                } else {
                    startActivity(new Intent(gf45d4f5.this, dsfvg1d45v1.class));
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

        if (!isVectorShow) {
            ((ImageView) findViewById(R.id.vector_pro)).setVisibility(View.GONE);
        }

        if (new dw4sd5sd4(this).getKeyOnresumenativeshow().equals("1")) {
            native_ShowAds(this, findViewById(R.id.native_container), 1);
        }
    }
}