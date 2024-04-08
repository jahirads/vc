package freecall.videocall.freelivechat.global.livecall;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ads.sdk.sf4d;
import freecall.videocall.freelivechat.global.livecall.dsd14s514.dsa5d145;

public class dgfdsfv5436 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.das4f154f);

        sf4d.ShowInterstitialAdsOnCreate(this);

        findViewById(R.id.tv_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(dgfdsfv5436.this, dsa5d145.class).putExtra("issplash", 2));
                finish();
            }
        });

        findViewById(R.id.tv_decline).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }

    @Override
    public void onBackPressed() {
    }
}