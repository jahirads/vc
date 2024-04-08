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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.ads.sdk.sf4d;
import com.ads.sdk.fdf4d46.dw4sd5sd4;

import freecall.videocall.freelivechat.global.livecall.R;


public class s4d185d4fv5 extends AppCompatActivity {

    private AppCompatButton gender_next;
    private LinearLayout ll_male, ll_female;
    private ImageView chk_male, chk_female;
    private boolean checker = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dfds1256f41);

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


        gender_next = findViewById(R.id.gender_next);
        ll_male = findViewById(R.id.ll_male);
        ll_female = findViewById(R.id.ll_female);
        chk_male = findViewById(R.id.chk_male);
        chk_female = findViewById(R.id.chk_female);

        ll_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checker = true;
                chk_male.setImageResource(R.drawable.check);
                chk_female.setImageResource(R.drawable.uncheck);
            }
        });

        ll_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checker = true;
                chk_male.setImageResource(R.drawable.uncheck);
                chk_female.setImageResource(R.drawable.check);
            }
        });

        gender_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checker) {
                    if (new dw4sd5sd4(s4d185d4fv5.this).getIncoming_Counter().equalsIgnoreCase(String.valueOf(incoming_counter))) {
                        connectInComing(s4d185d4fv5.this);
                    } else {
                        startActivity(new Intent(s4d185d4fv5.this, gf45d4f5.class));
                    }
                } else {
                    Toast.makeText(s4d185d4fv5.this, "select gender first!", Toast.LENGTH_SHORT).show();
                }
            }
        });
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

    @Override
    public void onBackPressed() {
        sf4d.ShowInterstitialAdsOnBack(this);
    }


}