package com.example.android.mrasyidridhotobing_1202150064_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

/**
 * Created by rasyidtobing on 25/02/2018.
 */

public class Air {
    private int gambar ;
    private String nama, details, komposisi;
    public Air(int gambar, String nama, String komposisi, String harga ) {
        this.gambar = gambar;
        this.nama = nama;
        this.details = harga;
        this.komposisi = komposisi;
    }

    public String getDetails() {
        return details;
    }

    public String getNama() {
        return nama;
    }

    public int getGambar() {
        return gambar;
    }
    public String getKomposisi() {
        return komposisi;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    public void setHarga(String harga) {
        this.details = harga;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


}
