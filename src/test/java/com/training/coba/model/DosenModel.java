package com.training.coba.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DosenModel {

    @SerializedName("nama")
    @Expose
    private String nama;
    @SerializedName("matkul")
    @Expose
    private String matkul;
    @SerializedName("no_hp")
    @Expose
    private String noHp;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMatkul() {
        return matkul;
    }

    public void setMatkul(String matkul) {
        this.matkul = matkul;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

}