package com.example.user.intent_multiaction;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by USER on 16/04/2018.
 */

public class Mahasiswa implements Parcelable {
    private String nama;
    private String asal;
    private String jurusan;
    private String email;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAsal() {
        return asal;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public String getJurusan() {
        return jurusan;
    }

    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.nama);
        dest.writeString(this.asal);
        dest.writeString(this.jurusan);
        dest.writeString(this.email);
    }

    public Mahasiswa() {
    }

    protected Mahasiswa(Parcel in) {
        this.nama = in.readString();
        this.asal = in.readString();
        this.jurusan = in.readString();
        this.email = in.readString();
    }

    public static final Parcelable.Creator<Mahasiswa> CREATOR = new Parcelable.Creator<Mahasiswa>() {
        @Override
        public Mahasiswa createFromParcel(Parcel source) {
            return new Mahasiswa(source);
        }

        @Override
        public Mahasiswa[] newArray(int size) {
            return new Mahasiswa[size];
        }
    };
}
