package com.denisha.lambung;

/**
 * Created by USER on 7/19/2016.
 */


    public class ContactModel {

    //private variables

    int _id;
    String _nama;
    String _usia;
    String _riwayat;

    // Empty constructor
    public ContactModel() {

    }

    // constructor
    public ContactModel(int _id, String _nama, String _usia, String _riwayat) {

        this._id = _id;
        this._nama = _nama;
        this._usia = _usia;
        this._riwayat = _riwayat;   }

    public ContactModel(String _nama, String _usia, String _riwayat) {

        this._nama = _nama;
        this._usia = _usia;
        this._riwayat = _riwayat;   }



    // getting ID
    public int getID() {
        return this._id;
    }

    // setting id
    public void setID(int id) {
        this._id = id;
    }

    // getting nama
    public String get_nama() {
        return this._nama;
    }

    // setting nama
    public void set_nama(String nama) {
        this._nama = nama;
    }

    // getting usia
    public String get_usia() {
        return this._usia;
    }

    // setting usia
    public void set_usia(String usia) {
        this._usia = usia;
    }


    //getting riwayat
    public String get_riwayat() { return this._riwayat; }

    //setting riwayat
    public void set_riwayat(String riwayat) { this._riwayat = riwayat;}
}
