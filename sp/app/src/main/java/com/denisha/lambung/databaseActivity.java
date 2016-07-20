package com.denisha.lambung;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class databaseActivity extends AppCompatActivity {
    public ArrayList<ContactModel> contactModels = new ArrayList<>();
    AdapterContact adapterContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);
        // toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        adapterContact = new AdapterContact(getApplicationContext());


        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.viewpager);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactModels = MyApplication.getWritableDatabase().getAllContacts();
        adapterContact.setContactList(contactModels);
        recyclerView.setAdapter(adapterContact);

        Log.d("ukuran contact model", Integer.toString(adapterContact.getItemCount()));

        Log.d("Ukururan" , Integer.toString(contactModels.size()));



    }
}

