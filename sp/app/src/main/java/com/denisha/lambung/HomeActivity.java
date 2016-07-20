package com.denisha.lambung;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       Button btn_diagnosis = (Button)findViewById(R.id.btn_diagnosis);
       btn_diagnosis.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View v) {
               Intent LoginActivity = new Intent(HomeActivity.this, LoginActivity.class);
               startActivity(LoginActivity);


           }
       });
        Button btn_riwayat  = (Button)findViewById(R.id.btn_riwayat);
        btn_riwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(HomeActivity.this, databaseActivity.class);
                startActivity(a);
            }
        });
        Button btn_infopenyakit = (Button)findViewById(R.id.btn_infopenyakit);
        btn_infopenyakit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent Daftar_Penyakit = new Intent(HomeActivity.this, Daftar_Penyakit.class);
                startActivity(Daftar_Penyakit);


            }
        });

        Button btn_poli = (Button)findViewById(R.id.btn_poli);
        btn_poli.setOnClickListener (new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent Poli_Penyakit = new Intent(HomeActivity.this,Poli_Penyakit.class);
                startActivity(Poli_Penyakit);


            }
        });



        Button btn_panduan = (Button)findViewById(R.id.btn_panduan);
        btn_panduan.setOnClickListener (new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                Intent Panduan = new Intent(HomeActivity.this,Panduan.class);
                startActivity(Panduan);


            }
        });

        Button btn_tentang = (Button)findViewById(R.id.btn_tentang);
        btn_tentang.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent Tentang_Aplikasi = new Intent(HomeActivity.this, Tentang_Aplikasi.class);
                startActivity(Tentang_Aplikasi);


            }
        });
        Button btn_keluar = (Button)findViewById(R.id.btn_keluar);
        btn_keluar.setOnClickListener (new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
              System.exit(1);

            }
        });
        }

}
