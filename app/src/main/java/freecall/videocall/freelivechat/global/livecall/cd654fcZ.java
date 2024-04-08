package freecall.videocall.freelivechat.global.livecall;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import freecall.videocall.freelivechat.global.livecall.adx12s51cd5.saf1ds22;

public class cd654fcZ extends AppCompatActivity {
    private TextView tv_policy1, tv_policy2, tv_policy3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f2d3f1d6f);

        tv_policy1 = findViewById(R.id.tv_policy1);
        tv_policy2 = findViewById(R.id.tv_policy2);
        tv_policy3 = findViewById(R.id.tv_policy3);

        String str1 = "Following link :" + " <a href=\"\"> <b> Terms and conditions of use </b> </a> ";
        tv_policy1.setText(Html.fromHtml(str1));
        tv_policy1.setLinkTextColor(getResources().getColor(R.color.blue_lnk));
        tv_policy1.setMovementMethod(LinkMovementMethod.getInstance());

        String str2 = "Following link :" + " <a href=\"\"> <b> Privacy Policy </b> </a> ";
        tv_policy2.setText(Html.fromHtml(str2));
        tv_policy2.setLinkTextColor(getResources().getColor(R.color.blue_lnk));
        tv_policy2.setMovementMethod(LinkMovementMethod.getInstance());

        String str3 = "Following link :" + " <a href=\"\"> <b> App Community Guidelines </b> </a> ";
        tv_policy3.setText(Html.fromHtml(str3));
        tv_policy3.setLinkTextColor(getResources().getColor(R.color.blue_lnk));
        tv_policy3.setMovementMethod(LinkMovementMethod.getInstance());

        tv_policy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cd654fcZ.this, saf1ds22.class);
                intent.putExtra("link", 1);
                startActivity(intent);
            }
        });

        tv_policy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cd654fcZ.this, saf1ds22.class);
                intent.putExtra("link", 2);
                startActivity(intent);

            }
        });

        tv_policy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(cd654fcZ.this, saf1ds22.class);
                intent.putExtra("link", 3);
                startActivity(intent);
            }
        });

        findViewById(R.id.tvAccept).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(cd654fcZ.this, dgfdsfv5436.class).putExtra("issplash", 2));
                finish();
            }
        });

        findViewById(R.id.tvReject).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
    }
}