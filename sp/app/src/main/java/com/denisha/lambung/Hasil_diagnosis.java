
package com.denisha.lambung;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Hasil_diagnosis extends AppCompatActivity {
    TextView txtStatus;
    public String nama, usia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_diagnosis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        final DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        SharedPreferences sharedPreferences = getSharedPreferences("hasil_diagnosis", MODE_PRIVATE);
       nama =  sharedPreferences.getString("nama",null);
        usia = sharedPreferences.getString("usia",null);
        Log.d("Nama dan Usia", nama + usia);


        setSupportActionBar(toolbar);
        txtStatus = (TextView)findViewById(R.id.hasilDiagnosis);
        Button btn_lanjut = (Button) findViewById(R.id.btn_lanjut);
        final Button btn_selesai = (Button) findViewById(R.id.btn_selesai);


        Intent intent = getIntent();
        TextView hasil = (TextView) findViewById(R.id.hasilDiagnosis);
        hasil.setText(intent.getStringExtra("hasil"));
        db.addContact(new ContactModel(nama, usia,intent.getStringExtra("hasil")));


        SharedPreferences hasill = getSharedPreferences("Hasil_diagnosis", MODE_PRIVATE);
        hasill.getString("nama", null);
        hasill.getString("usia", null);
        hasill.getString("riwayat", null);

        if (txtStatus.getText().toString().equals("Maaf, kami tidak dapat mendiagnosis jenis penyakit yang sedang anda derita. Segera periksakan diri ke dokter."))
            btn_lanjut.setVisibility(View.GONE); {




        }

        btn_lanjut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (txtStatus.getText().toString().equals("Anda di Diagnosis Terkena Penyakit GERD.")) {
                    Intent i = new Intent(Hasil_diagnosis.this, FaktorResiko_Penyakit.class);
                    startActivity(i);
                } else if (txtStatus.getText().toString().equals("Anda di Diagnosis Terkena Penyakit ULKUS PEPTIKUM.")) {
                    Intent i = new Intent(Hasil_diagnosis.this, FaktorResiko2.class);
                    startActivity(i);
                } else if (txtStatus.getText().toString().equals("Anda di Diagnosis Terkena Penyakit GASTRITIS AKUT.")) {
                    Intent i = new Intent(Hasil_diagnosis.this, FaktorResiko3.class);
                    startActivity(i);
                } else if (txtStatus.getText().toString().equals("Anda di Diagnosis Terkena Penyakit GASTRITIS KRONIS.")) {
                    Intent i = new Intent(Hasil_diagnosis.this, FaktorResiko4.class);
                    startActivity(i);

                }





            }
        });


    }

    public void selesai_btn(View view){
        Intent home  = new Intent(this,HomeActivity.class);
        home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home);
    }
}

