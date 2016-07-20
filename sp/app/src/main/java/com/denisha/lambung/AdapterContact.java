package com.denisha.lambung;

/**
 * Created by USER on 7/19/2016.
 */
import android.content.Context;
import android.support.v7.view.ContextThemeWrapper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class AdapterContact extends RecyclerView.Adapter<RecyclerView.ViewHolder>   {
    public Context context;
    private ArrayList<ContactModel> mContact = new ArrayList<>();
    public AdapterContact(Context context){
        this.context = context;

    }
    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ContactViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_user,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ContactViewHolder contactViewHolder = (ContactViewHolder) holder;
        ContactModel contactModel = mContact.get(position);

        contactViewHolder.tvNama.setText("Nama :  " + contactModel.get_nama());
        contactViewHolder.tvUsia.setText("Usia : " + contactModel.get_usia());
        contactViewHolder.tvRiwayat.setText("Riwayat Diagnosis : " + contactModel.get_riwayat());
    }

    @Override
    public int getItemCount() {
        return mContact.size();
    }
    public void setContactList(ArrayList<ContactModel> listContact) {
        this.mContact = listContact;
        //update the adapter to reflect the new set of movies
        notifyDataSetChanged();
    }
    static class ContactViewHolder  extends RecyclerView.ViewHolder{
        TextView tvNama,tvUsia,tvRiwayat;
        Context context;

        public ContactViewHolder(View inflate) {
            super(inflate);
            context = inflate.getContext();
            tvNama = (TextView) inflate.findViewById(R.id.tvNama);
            tvUsia = (TextView) inflate.findViewById(R.id.tvUsia);
            tvRiwayat = (TextView) inflate.findViewById(R.id.tvRiwayat);

        }
    }
}

