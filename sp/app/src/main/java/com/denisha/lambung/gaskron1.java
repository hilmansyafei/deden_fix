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

public class gaskron1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaskron1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        Button btn_homegaskron = (Button) findViewById(R.id.btn_homegaskron);
        btn_homegaskron.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent HomeActvity = new Intent(gaskron1.this, HomeActivity.class);
                startActivity(HomeActvity);


            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        WebView webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/gastritiskronis.html");
    }

}
