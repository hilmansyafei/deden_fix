package com.denisha.lambung;

/**
 * Created by USER on 6/17/2016.
 */
public class ModelRumahSakit {

    private String noTelp;
    private String namaRumahSakit;
    private int gambarRs;
    private float latRs;
    private float longRs;

    public void ModelRumahSakit(){

    }

    public void setNoTelp(String noTelp){
        this.noTelp = noTelp;
    }
    public String getNoTelp(){
        return noTelp;
    }
    public void setNamaRumahSakit(String namaRumahSakit){this.namaRumahSakit = namaRumahSakit;}
    public String getNamaRumahSakit(){
        return namaRumahSakit;
    }
    public void setGambarRs(int gambarRs){this.gambarRs = gambarRs;}
    public int getGambarRs(){return gambarRs;}
    public void setLatRs(float latRs){this.latRs = latRs;}
    public float getLatRs(){return latRs;}
    public void setLongRs(float longRs){this.longRs = longRs;}
    public float getLongRs(){return longRs;}
}
