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
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Scanner;

public class diagnosis extends AppCompatActivity {
    TextView diagnosis_isi;
    int data [] = new int [20];
    String diagnosis[] = new String [20];
    public int number=0;
    public String hasil_diagnosis="";
    RadioButton jawaban_ya;
    RadioButton jawaban_tidak;
    RadioButton lempar;
    int count_gerd = 0;
    int count_ulkus = 0;
    int count_gastritis_akut=0;
    int count_gastritis_kron =0;
    int jawaban [] =  new int[20];
    int gerd[] = new int[10];
    int ulkus[] = new int[9];
    int gastritis_akut[] = new int[7];
    int gastritis_kron[] = new int[8];
    Button nn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        diagnosis_isi = (TextView)findViewById(R.id.tvPertanyaan);
        jawaban_ya = (RadioButton)findViewById(R.id.rbYa);
        jawaban_tidak = (RadioButton)findViewById(R.id.rbTidak);
        lempar = (RadioButton)findViewById(R.id.lempar_rbn);
        nn = (Button)findViewById(R.id.btn_next);




        diagnosis [0] = "Apakah anda merasakan mual ?";
        diagnosis [1] = "Apakah anda merasakan dada terasa panas seperti terbakar ?";
        diagnosis [2] = "Apakah anda merasakan perut anda kembung ?";
        diagnosis [3] = "Apakah anda merasakah nyeri pada ulu hati ?";
        diagnosis [4] = "Apakah anda sering buang angin ?";
        diagnosis [5] = "Apakah anda muntah ?";
        diagnosis [6] = "Apakaha anda merasakan mulas dan perut tidak enak ?";
        diagnosis [7] = "Apakah anda mengalami penurunan berat badan ?";
        diagnosis [8] = "Apakah lidah anda terasa pahit ?";
        diagnosis [9] = "Apakah perut anda nyeri saat diisi makanan ?";
        diagnosis [10] = "Apakah anda mengalami kesulitan menelan makanan ?";
        diagnosis [11] = "Apakah dada anda terasa nyeri dan berdebar ?";
        diagnosis [12] = "Apakah anda mengalami serak dan batuk ?";
        diagnosis [13] = "Apakah anda mengalami muntah darah ?";
        diagnosis [14] = "Apakah feses anda berwarna hitam ?";
        diagnosis [15] = "Apakah anda hilang nafsu makan ?";
        diagnosis [16] = "Apakah anda merasa lemas ? Seperti anemia ?";
        diagnosis [17] = "Apakah anda merasakan nyeri tenggorakan dan bau nafas ?";
        diagnosis [18] = "Apakah nafas anda bunyi mengi ?";
        diagnosis [19] = "Apakah anda sering bersendawa dan cegukan ?";
        diagnosis_isi.setText("No "+(1)+" : "+diagnosis[0]);



        gerd[0] = 0;//pertanyaan 1
        gerd[1] = 1;//pertanyan 2
        gerd[2] = 4;//pertanyaan 5
        gerd[3] = 8;//pertannyaan 9
        gerd[4] = 10;//pertanyaan 11
        gerd[5] = 11;//pertanyaan 12
        gerd[6] = 12;//pertanyaan 13
        gerd[7] = 17;//pertanyaan 18
        gerd[8] = 18;//pertanyaan 19
        gerd[9] = 19;//pertanyaan 20

        ulkus[0]  = 0;//pertanyaan 1
        ulkus[1]  = 2;//pertanyaan 3
        ulkus[2]  = 3;//pertanyaan 4
        ulkus[3]  = 5;//pertanyaan 6
        ulkus[4]  = 6;//pertanyaan 7
        ulkus[5]  = 7;//pertanyaan 8
        ulkus[6]  = 9;//pertanyaan 10
        ulkus[7]  = 15;//pertanyaan 16
        ulkus[8]  = 16;//pertanyaan 17

        gastritis_akut[0] = 0;//pertanyaan 1
        gastritis_akut[1] = 2;//pertanyaan 3
        gastritis_akut[2] = 3;//pertanyaan 4
        gastritis_akut[3] = 5;//pertanyaan 6
        gastritis_akut[4] = 6;//pertanyaan 7
        gastritis_akut[5] = 15;//pertanyaan 16
        gastritis_akut[6] = 16;//pertanyaan 17


        gastritis_kron[0] = 0;//pertanyaan 1
        gastritis_kron[1] = 3;//pertanyaan 4
        gastritis_kron[2] = 5;//pertanyaan 6
        gastritis_kron[3] = 6;//pertanyaan 7
        gastritis_kron[4] = 7;//pertanyaan 8
        gastritis_kron[5] = 8;//pertanyaan 9
        gastritis_kron[6] = 13;//pertanyaan 14
        gastritis_kron[7] = 14;//pertanyaan 15






    }

    public void nextbutton (View view) {
        if (jawaban_ya.isChecked()){
            jawaban[number]= 1;
            number++;
            lempar.setChecked(true);
        }else{
            if(jawaban_tidak.isChecked()){
                number++;
                lempar.setChecked(true);
                jawaban[number]=0;
            }

        }



        if (number>18){
            cek_penyakit(jawaban);
            Intent Hasil = new Intent(this,Hasil_diagnosis.class);
            Hasil.putExtra("hasil", hasil_diagnosis);
            startActivity(Hasil);
            //diagnosis_isi.setText(hasil_diagnosis);
        }else {
            diagnosis_isi.setText("No "+(number+1)+" : "+diagnosis[number]);
        }
    }

    public  void prevbutton(View View){
        if (number>0){
            number--;
            diagnosis_isi.setText("No "+(number+1)+" : "+diagnosis[number]);
        }
    }

    void cek_penyakit(int jawaban_param[]){
        for(int j =0;j<data.length;j++){
            if(jawaban_param[j]==1){
                for(int k = 0;k<data.length;k++){
                    try{
                        if((j)==gerd[k]){
                            count_gerd++;
                        }
                    }catch(IndexOutOfBoundsException e){
                    }
                    try{
                        if ((j)==ulkus[k]){
                            count_ulkus++;
                        }
                    }catch(IndexOutOfBoundsException e){
                    }
                    try{
                        if((j)==gastritis_akut[k]){
                            count_gastritis_akut++;
                        }
                    }catch(IndexOutOfBoundsException e){
                    }
                    try{
                        if((j)==gastritis_kron[k]){
                            count_gastritis_kron++;
                        }
                    }catch(IndexOutOfBoundsException e){
                    }
                }
            }

        }


        SharedPreferences editor1 = getSharedPreferences("hasil_diagnosis", MODE_PRIVATE);

        Log.v("_TES",count_gerd+" "+count_gastritis_akut+" "+count_gastritis_kron+" "+count_ulkus);
        if(count_gerd > count_ulkus && count_gerd > count_gastritis_akut && count_gerd > count_gastritis_kron ){
            hasil_diagnosis = "Anda di Diagnosis Terkena Penyakit GERD.";
        }else if(count_ulkus > count_gerd && count_ulkus > count_gastritis_akut && count_ulkus > count_gastritis_kron){
            hasil_diagnosis = "Anda di Diagnosis Terkena Penyakit ULKUS PEPTIKUM.";
        }else if(count_gastritis_akut > count_ulkus && count_gastritis_akut > count_gerd && count_gastritis_akut > count_gastritis_kron){
            hasil_diagnosis = "Anda di Diagnosis Terkena Penyakit GASTRITIS AKUT.";
        }else if(count_gastritis_kron > count_ulkus && count_gastritis_kron > count_gerd && count_gastritis_kron > count_gastritis_akut){
            hasil_diagnosis = "Anda di Diagnosis Terkena Penyakit GASTRITIS KRONIS.";
        }else{
            hasil_diagnosis = "Maaf, kami tidak dapat mendiagnosis jenis penyakit yang sedang anda derita. Segera periksakan diri ke dokter.";
        }
    }




}





