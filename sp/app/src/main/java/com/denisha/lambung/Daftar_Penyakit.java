package com.denisha.lambung;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class Daftar_Penyakit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar__penyakit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button btn_infogerd = (Button) findViewById(R.id.btn_infogerd);
        btn_infogerd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent gerd1 = new Intent(Daftar_Penyakit.this, gerd1.class);
                startActivity(gerd1);


            }
        });

        Button btn_infoulkus = (Button) findViewById(R.id.btn_infoulkus);
        btn_infoulkus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent ulkus1 = new Intent(Daftar_Penyakit.this, ulkus1.class);
                startActivity(ulkus1);


            }
        });


        Button btn_infogasakut = (Button) findViewById(R.id.btn_infogasakut);
        btn_infogasakut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent gastritis1 = new Intent(Daftar_Penyakit.this, gastritis1.class);
                startActivity(gastritis1);


            }
        });

        Button btn_infogaskron = (Button) findViewById(R.id.btn_infogaskron);
        btn_infogaskron.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent gaskron1 = new Intent(Daftar_Penyakit.this, gaskron1.class);
                startActivity(gaskron1);



            }
        });
    }
}
