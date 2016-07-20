package com.denisha.lambung;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class LoginActivity extends AppCompatActivity {

        private EditText editNama;
        private EditText editUsia;
        private Button btnMasuk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       final SharedPreferences.Editor editor = getSharedPreferences("hasil_diagnosis", MODE_PRIVATE).edit();



        setContentView(R.layout.activity_login);

        editNama = (EditText)
                findViewById(R.id.editNama);
        editUsia = (EditText)
                findViewById(R.id.editUsia);

        btnMasuk = (Button)
                findViewById(R.id.btnMasuk);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editNama.getText().toString();
                editUsia.getText().toString();
                editor.putString("nama",editNama.getText().toString());
                editor.putString("usia",editUsia.getText().toString());
                editor.commit();

                Intent diagnosis = new Intent(LoginActivity.this, diagnosis.class);
                startActivity(diagnosis);





            }
        });
    }
    }
