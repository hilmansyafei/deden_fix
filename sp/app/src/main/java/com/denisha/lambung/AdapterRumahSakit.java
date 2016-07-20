package com.denisha.lambung;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by USER on 6/17/2016.
 */
public class AdapterRumahSakit extends RecyclerView.Adapter<AdapterRumahSakit.ViewHolderRumahSakit> {

    private List<ModelRumahSakit> rumahSakitList;
    private Context context;
    public AdapterRumahSakit(List<ModelRumahSakit> modelRumahSakitList, Context context) {
        this.rumahSakitList = modelRumahSakitList;
        this.context= context;
    }

    @Override
    public ViewHolderRumahSakit onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.list_rumah_sakit, parent, false);

        return new ViewHolderRumahSakit(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderRumahSakit holder, int position){

        final ModelRumahSakit modelRumahSakit = rumahSakitList.get(position);
        holder.namaRS.setText(modelRumahSakit.getNamaRumahSakit());
        holder.noTelp.setText(modelRumahSakit.getNoTelp());
        holder.gambarRs.setImageResource(modelRumahSakit.getGambarRs());
        holder.setClickListener(new itemClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("geo:0,0?q="+modelRumahSakit.getLatRs()+","+modelRumahSakit.getLongRs()+"("+modelRumahSakit.getNamaRumahSakit()+")"));
                view.getContext().startActivity(intent);
            }
        });

    }
    @Override
    public int getItemCount() {
        return rumahSakitList.size();
    }

    static class ViewHolderRumahSakit extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView namaRS;
        TextView noTelp;
        ImageView gambarRs;
        private itemClickListener clickListener;

        public ViewHolderRumahSakit(View itemView) {
            super(itemView);
            namaRS = (TextView) itemView.findViewById(R.id.namaRs);
            noTelp = (TextView) itemView.findViewById(R.id.noTelp);
            gambarRs = (ImageView) itemView.findViewById(R.id.iconRs);
            itemView.setOnClickListener(this);
        }
        public void setClickListener(itemClickListener itemClickListener) {
            this.clickListener = itemClickListener;
        }
        @Override
        public void onClick(View view)
        {
            int position = getAdapterPosition();
            clickListener.onClick(view, position);
        }
    }
}
