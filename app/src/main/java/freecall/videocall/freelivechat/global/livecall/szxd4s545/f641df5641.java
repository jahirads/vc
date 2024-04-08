package freecall.videocall.freelivechat.global.livecall.szxd4s545;

import static freecall.videocall.freelivechat.global.livecall.dsd14s514.dsa5d145.isVectorShow;
import static freecall.videocall.freelivechat.global.livecall.s2d1s31d.f151d5vf.isNetworkConnected;
import static freecall.videocall.freelivechat.global.livecall.s2d1s31d.f151d5vf.native_ShowAds;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ads.sdk.sf4d;
import com.ads.sdk.fdf4d46.dw4sd5sd4;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import freecall.videocall.freelivechat.global.livecall.R;
import freecall.videocall.freelivechat.global.livecall.fc2ds63526.MainActivity;
import freecall.videocall.freelivechat.global.livecall.adx12s51cd5.sdfs21d21;

public class f641df5641 extends AppCompatActivity {

    private TextView note;
    private boolean backer = false;
    private LottieAnimationView lottie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dsa4f5314);

        if (!isVectorShow) {
            ((ImageView) findViewById(R.id.vector_pro)).setVisibility(View.GONE);
        }

        note = findViewById(R.id.note);
        lottie = findViewById(R.id.lottie);

        dw4sd5sd4.show_anim_header(this, (RelativeLayout) findViewById(R.id.rl_anim_header));
        sf4d.ShowInterstitialAdsOnCreate(this);
        if (new dw4sd5sd4(this).getKeyOnresumenativeshow().equals("0")) {
            native_ShowAds(this, findViewById(R.id.native_container), 1);
        }


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                backer = true;
                if (new dw4sd5sd4(f641df5641.this).getVideo_call().equalsIgnoreCase("1")) {
                    lottie.setAnimation("suc.json");
                    lottie.playAnimation();
                    lottie.loop(true);
                    note.setTextColor(getResources().getColor(R.color.green));
                    note.setText("Video Call Connected!");
                    TextView button = findViewById(R.id.my_button);
                    button.setVisibility(View.VISIBLE);
                    button.setText("JOIN");
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if (isNetworkConnected(f641df5641.this)) {
                                Show_Dialog();
                            }
                        }
                    });

                } else {
                    lottie.setAnimation("failed.json");
                    lottie.loop(true);
                    lottie.setRepeatMode(LottieDrawable.RESTART);
                    lottie.playAnimation();
                    note.setTextColor(Color.RED);
                    note.setText("People not found!");
                    TextView button = findViewById(R.id.my_button);
                    button.setVisibility(View.VISIBLE);
                    button.setText("TRY AGAIN");
                    button.setBackground(getResources().getDrawable(R.drawable.ad_exit_three));
                    button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (isNetworkConnected(f641df5641.this))
                                startActivity(new Intent(f641df5641.this, f641df5641.class));
                            finish();
                        }
                    });
                }
            }
        }, 6000);
    }

    private void Show_Dialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(f641df5641.this);
        final View view = getLayoutInflater().inflate(R.layout.das35das53d4l, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.setCancelable(true);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        TextView txt_con = view.findViewById(R.id.txt_con);
        txt_con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();

                if (new dw4sd5sd4(f641df5641.this).getKeyInAppMode().equals("1")) {

                    if (new sdfs21d21().getVipType().equals("in_app_gold") || new sdfs21d21().getVipType().equals("in_app_silver") || new sdfs21d21().getVipType().equals("in_app_bronze")) {
                        startActivity(new Intent(f641df5641.this, f4ds6f4ds6f54.class));
                        finish();
                    } else {
                        if (new sdfs21d21().isFreeTrailActive()) {
                            new sdfs21d21().setFreeTrail(false);
                            startActivity(new Intent(f641df5641.this, f4ds6f4ds6f54.class));
                            finish();
                        } else {
                            startActivity(new Intent(f641df5641.this, MainActivity.class));
                        }
                    }

                } else {
                    startActivity(new Intent(f641df5641.this, f4ds6f4ds6f54.class));
                    finish();
                }


            }
        });
        dialog.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (new dw4sd5sd4(this).getKeyOnresumenativeshow().equals("1")) {
            native_ShowAds(this, findViewById(R.id.native_container), 1);
        }
    }


    @Override
    public void onBackPressed() {
        if (backer) {
            try {
                sf4d.ShowInterstitialAdsOnBack(this);
            } catch (Exception e) {
                finish();
                e.printStackTrace();
            }
        }
    }
}