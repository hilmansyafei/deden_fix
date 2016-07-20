package com.denisha.lambung;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class gerd1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerd1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Button btn_homegerd = (Button) findViewById(R.id.btn_homegerd);
        btn_homegerd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent HomeActvity = new Intent(gerd1.this, HomeActivity.class);
                startActivity(HomeActvity);


            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/gerd.html");

    }

}
