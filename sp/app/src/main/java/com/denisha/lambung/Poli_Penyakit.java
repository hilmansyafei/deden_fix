package com.denisha.lambung;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;



import java.util.ArrayList;
import java.util.List;

public class Poli_Penyakit extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String[] namaRumahSakit;
    private String[]  noTelpRs;
    private int []  gambarRs;
    private double[] latRs;
    private double[] longRs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poli__penyakit);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //array Data
        namaRumahSakit = new String[]{"Rumah Sakit Umum Depok", "Rumah Sakit Bhayangkara Brimob", "Rumah Sakit Hermina Depok", "Rumah Sakit Bhakti Yudha",
        "Rumah Sakit Meilia","Rumah Sakit Bunda Margonda","Rumah Sakit Puri Cinere","Rumah Sakit Tugu Ibu","Rumah Sakit Simpangan Depok","Rumah Sakit Mitra Keluarga"};
        noTelpRs = new String[]{"021-8708266","87716060","021-77202525","021-7520082","021-8444444","021-78890551","021-7545488","021-8711693","021-8741549/8747620","021-77210800"};
        gambarRs = new int[]{R.drawable.hospitall,R.drawable.hospitall,R.drawable.hospitall,R.drawable.hospitall,R.drawable.hospitall,R.drawable.hospitall,R.drawable.hospitall,R.drawable.hospitall,R.drawable.hospitall,R.drawable.hospitall};
        latRs = new double[]{-6.403382,-6.354784, -6.399542, -6.397313, -6.376407, -6.365135, -6.321600, -6.356299, -6.408436, -6.394255};
        longRs = new double[]{106.758573,106.849281,106.825240,106.806130,106.901819,106.835210, 106.782548, 106.859967, 106.861605, 106.824193};

        //RecycleView Start
        recyclerView = (RecyclerView) findViewById(R.id.list_rs);
        recyclerView.setLayoutManager(new GridLayoutManager(Poli_Penyakit.this,2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //Populate RecycleView
        AdapterRumahSakit adapterRumahSakit = new AdapterRumahSakit(createList(),getApplicationContext());
        recyclerView.setAdapter(adapterRumahSakit);
    }
    private List<ModelRumahSakit> createList() {

        List<ModelRumahSakit> result = new ArrayList();
        for (int i=0; i < 10; i++) {
            ModelRumahSakit modelRumahSakit = new ModelRumahSakit();
            modelRumahSakit.setNamaRumahSakit(namaRumahSakit[i]);
            modelRumahSakit.setNoTelp(noTelpRs[i]);
            modelRumahSakit.setGambarRs(gambarRs[i]);
            modelRumahSakit.setLatRs((float) (latRs[i]));
            modelRumahSakit.setLongRs((float)(longRs[i]));
            result.add(modelRumahSakit);
        }

        return result;
    }
}

