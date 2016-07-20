package com.denisha.lambung;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public static int SPLASH_TIME_OUT = 1500;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);

                    finish();
                }
            }, SPLASH_TIME_OUT);


    }

}

