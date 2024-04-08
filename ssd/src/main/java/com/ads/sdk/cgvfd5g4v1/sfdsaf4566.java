package com.ads.sdk.cgvfd5g4v1;

import static com.ads.sdk.fdf4d46.dw4sd5sd4.dsf4dsf45List;
import static com.ads.sdk.cgvfd5g4v1.dsfdf563.notify_Pos;

import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import com.ads.sdk.R;

public class sfdsaf4566 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saf4ds54f);

        String url = dsf4dsf45List.get(notify_Pos).getNotifyLink();
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(url));
        finish();
    }
}